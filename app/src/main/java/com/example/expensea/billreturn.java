package com.example.expensea;

public class billreturn {
        private String name;
        private int each;
        private String Person1_name;
        private String Person2_name;
        private String Person3_name;
        private String Person4_name;
        private String Person5_name;

        public billreturn(String name, int each, String person1_name, String person2_name, String person3_name, String person4_name, String person5_name) {
            this.name = name;
            this.each = each;
            this.Person1_name = person1_name;
            this.Person2_name = person2_name;
            this.Person3_name = person3_name;
            this.Person4_name = person4_name;
            this.Person5_name = person5_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getEach() {
            return each;
        }

        public void setEach(int each) {
            this.each = each;
        }

        public String getPerson1_name() {
            return Person1_name;
        }

        public void setPerson1_name(String person1_name) {
            Person1_name = person1_name;
        }

        public String getPerson2_name() {
            return Person2_name;
        }

        public void setPerson2_name(String person2_name) {
            Person2_name = person2_name;
        }

        public String getPerson3_name() {
            return Person3_name;
        }

        public void setPerson3_name(String person3_name) {
            Person3_name = person3_name;
        }

        public String getPerson4_name() {
            return Person4_name;
        }

        public void setPerson4_name(String person4_name) {
            Person4_name = person4_name;
        }

        public String getPerson5_name() {
            return Person5_name;
        }

        public void setPerson5_name(String person5_name) {
            Person5_name = person5_name;
        }



        @Override
        public String toString() {
            return "billreturn{" +
                    "name='" + name + '\'' +
                    ", each=" + each +
                    ", Person1_name='" + Person1_name + '\'' +
                    ", Person2_name='" + Person2_name + '\'' +
                    ", Person3_name='" + Person3_name + '\'' +
                    ", Person4_name='" + Person4_name + '\'' +
                    ", Person5_name='" + Person5_name + '\'' +
                    '}';
        }


    }
