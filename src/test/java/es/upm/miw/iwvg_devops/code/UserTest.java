package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    public static final String NAME_MIGUEL = "Miguel";
    public static final String NAME_CARLOS = "Carlos";
    public static final String NAME_LUIS = "Luis";
    public static final String FAMILYNAME_FLORES = "Flores";
    public static final String FAMILYNAME_CORTAZAR = "Cortazar";
    public static final String FAMILYNAME_RIVERA = "Rivera";
    public static final String ID_USER_1 = "USER_1";
    public static final String ID_USER_2 = "USER_2";
    public static final String ID_USER_3 = "USER_3";
    private List<User> users;

    @BeforeEach
    void setUp() {
        users = new ArrayList<>();
        users.add(new User(ID_USER_1, NAME_MIGUEL, FAMILYNAME_FLORES));
        users.add(new User(ID_USER_2, NAME_CARLOS, FAMILYNAME_CORTAZAR));
        users.add(new User(ID_USER_3, NAME_LUIS, FAMILYNAME_RIVERA));
    }

    @Test
    void getIdTest() {
        String[] expectedIds = {ID_USER_1, ID_USER_2, ID_USER_3};
        for (int i = 0; i < users.size(); i++) {
            assertEquals(expectedIds[i], users.get(i).getId());
        }
    }

    @Test
    void setNameTest() {
        String[] expectedNames = {"Roberto", "Miguel", "Abel"};

        for (int i = 0; i < users.size(); i++) {
            users.get(i).setName(expectedNames[i]);
        }
        for (int i = 0; i < users.size(); i++) {
            assertEquals(expectedNames[i], users.get(i).getName());
        }
    }


    @Test
    void setFamilyNameTest() {
        String[] expectedNames = {"App1", "App2", "App3"};

        for (int i = 0; i < users.size(); i++) {
            users.get(i).setFamilyName(expectedNames[i]);
        }
        for (int i = 0; i < users.size(); i++) {
            assertEquals(expectedNames[i], users.get(i).getFamilyName());
        }
    }
    @Test
    void fullNameTest() {
        String[] expectedFullNames = {
                NAME_MIGUEL +" " + FAMILYNAME_FLORES,
                NAME_CARLOS +" " + FAMILYNAME_CORTAZAR,
                NAME_LUIS +" " + FAMILYNAME_RIVERA,
        };
        for (int i = 0; i < users.size(); i++) {
            assertEquals(expectedFullNames[i], users.get(i).fullName());
        }
    }

    @Test
    void getInitialsTest() {
        String[] expectedInitials = {"M.", "C.", "L."};
        for (int i = 0; i < users.size(); i++) {
            assertEquals(expectedInitials[i], users.get(i).initials());
        }
    }

}
