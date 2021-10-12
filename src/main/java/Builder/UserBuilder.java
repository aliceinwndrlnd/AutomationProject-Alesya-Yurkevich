package Builder;

import lombok.Getter;

//Builder
@Getter
public class UserBuilder {
    String username;
    String password;

    public static class Builder {

        private UserBuilder userBuilder; //экземпляр класса

        public Builder() {
            userBuilder = new UserBuilder(); //конструктор, который будет создавать экземпляр переменной
        }


        public Builder withUsername(String username){
            userBuilder.username = username;
            return this;
        }

        public Builder withPassword(String password){
            userBuilder.password = password;
            return this;
        }

        public UserBuilder build() { //build, вернет наполненный новый компонент new user. Метод, который относится к userBuilder
           return userBuilder;
        }
    }

    @Override
    public String toString() { //чтобы вывести в тесте в консоль
        return "UserBuilder{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

