package com.flowerchar.junit5params;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestedExampleTest {

    @Nested
    class AuthorityManage{
        @Nested
        class Manager{
            @Test
            void addUser(){
                System.out.println("add user");
            }

            @Test
            void deleteUser(){
                System.out.println("delete user");
            }
        }

        @Test
        void employeeManage(){
            System.out.println("employee manage");
        }
    }

    @Nested
    class UserManager{
        @Test
        void addUser(){
            System.out.println("add user");
        }

        @Test
        void deleteUser(){
            System.out.println("delete user");
        }
    }
}
