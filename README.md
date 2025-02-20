#### ConfigManager como Singleton
Crie uma classe `ConfigManager` que armazena configurações globais da aplicação. Use o Spring Boot para garantir que apenas uma instância dessa classe exista.

**Passos:**
1. Crie uma classe `ConfigManager` com métodos para adicionar e recuperar configurações.
2. Use a anotação `@Component` para torná-la um bean gerenciado pelo Spring.
3. O Spring Boot, por padrão, cria beans como Singletons.

**Código:**
```java
package dio.exercicio.prototype;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component // Singleton por padrão no Spring
public class ConfigManager {
    private final Map<String, String> configs = new HashMap<>();

    public void setConfig(String key, String value) {
        configs.put(key, value);
    }

    public String getConfig(String key) {
        return configs.get(key);
    }
}
```

**Uso:**
```java
package dio.exercicio.prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SingletonExampleApp implements CommandLineRunner {

    @Autowired
    private ConfigManager configManager;

    public static void main(String[] args) {
        SpringApplication.run(SingletonExampleApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        configManager.setConfig("theme", "dark");
        System.out.println(configManager.getConfig("theme")); // Saída: dark
    }
}
```

**Saída:**
```
dark
```

---

#### Car como Prototype
Crie uma classe `Car` que representa um carro. Use o Spring Boot para permitir a clonagem de objetos `Car` com o escopo `prototype`.

**Passos:**
1. Crie a classe `Car` com propriedades como `model`, `color` e `year`.
2. Use a anotação `@Scope("prototype")` para definir o escopo como prototype.

**Código:**
```java
package dio.exercicio.prototype;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // Define o escopo como prototype
public class Car {
    private String model;
    private String color;
    private int year;

    // Getters e Setters
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    @Override
    public String toString() {
        return "Car [model=" + model + ", color=" + color + ", year=" + year + "]";
    }
}
```

**Uso:**
```java
package dio.exercicio.prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PrototypeExampleApp implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(PrototypeExampleApp.class, args);
    }

    @Override
    public void run(String... args) {
        Car car1 = context.getBean(Car.class);
        car1.setModel("Sedan");
        car1.setColor("blue");
        car1.setYear(2020);

        Car car2 = context.getBean(Car.class);
        car2.setModel("SUV");
        car2.setColor("red");
        car2.setYear(2021);

        System.out.println(car1);
        System.out.println(car2);
    }
}
```

**Saída:**
```
Car [model=Sedan, color=Blue, year=2020]
Car [model=SUV, color=Red, year=2021]
```
