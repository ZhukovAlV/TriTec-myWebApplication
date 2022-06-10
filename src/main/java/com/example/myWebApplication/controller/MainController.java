package com.example.myWebApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.Random;

@Controller
public class MainController {

  @GetMapping("/{a}/{b}/{operation}")
  public String mainPage(Model model, @PathVariable String a, @PathVariable String b, @PathVariable String operation) {
      int aInt = Integer.parseInt(a);
      int bInt = Integer.parseInt(b);

      if(operation.equals("+")) model.addAttribute("result", aInt + bInt);
      else if (operation.equals("-")) model.addAttribute("result", aInt - bInt);
      else if (operation.equals("*")) model.addAttribute("result", aInt * bInt);
      else if (operation.equals(":")) model.addAttribute("result", aInt / bInt);

      return "index";
  }

    @PostMapping("/calculator")
    public String postExample(Model model, @RequestParam String a, @RequestParam String b, @RequestParam String operation) {
        int aInt = Integer.parseInt(a);
        int bInt = Integer.parseInt(b);

        switch (operation) {
            case "+" -> model.addAttribute("result", aInt + bInt);
            case "-" -> model.addAttribute("result", aInt - bInt);
            case "*" -> model.addAttribute("result", aInt * bInt);
            case ":" -> model.addAttribute("result", aInt / bInt);
        }
        return "index";
    }

    @GetMapping("/prediction")
    public String greetMessage(Model model) {
        // Переменная для нашего предсказания
        String ourPrediction = null;

        // Cлучайное число
        Random random = new Random();
        long num = random.nextInt(10) + 1;

        try {
            // Переменная с именем драйвера для поделючения
            String driverName = "org.h2.Driver";
            // URL, где база находится и имя базы
            String url = "jdbc:h2:mem:testdb";
            // Имя пользователя
            String user = "sa";
            // Пароль
            String password = "sa";

            // Наше подключение
            Connection connection = DriverManager.getConnection(url,user,password);
            // Наш запрос
            String query = "SELECT * FROM prediction WHERE id =" + num + ";";
            // Создаем заявку для нашего запроса (сеанс)
            Statement statement = connection.createStatement();
            // Выполняем запрос и записываем результат в ResultSet
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ourPrediction = resultSet.getString("name");
            }

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // Передаем результат в браузер
        if (ourPrediction != null) model.addAttribute("message", ourPrediction);
        else model.addAttribute("message", "Предсказание для Вас не нашлось");

        return "prediction";
    }
}
