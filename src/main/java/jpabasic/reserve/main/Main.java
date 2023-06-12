package jpabasic.reserve.main;

import jpabasic.reserve.app.ChangeNameService;
import jpabasic.reserve.app.GetUserService;
import jpabasic.reserve.app.NewUserService;
import jpabasic.reserve.app.RemoveUserService;
import jpabasic.reserve.domain.EMF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    private static NewUserService newUserService = new NewUserService();
    private static GetUserService getUserService = new GetUserService();
    private static ChangeNameService changeNameService = new ChangeNameService();
    private static RemoveUserService removeUserService = new RemoveUserService();

    public static void main(String[] args) throws IOException {
        EMF.init();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("명령어를 입력하세요: ");
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                if (line.startsWith("new ")) {
                    handleNew(line);
                }
                else if (line.startsWith("get ")) {
                    handleGet(line);
                }
                else if (line.startsWith("change name ")) {
                    handleChangeName(line);
                }
                else if (line.startsWith("remove ")) {
                    handleRemove(line);
                }
                else if (line.startsWith("exit ")) {
                    break;
                }
            }
        } finally {
            EMF.close();
        }
    }
}
