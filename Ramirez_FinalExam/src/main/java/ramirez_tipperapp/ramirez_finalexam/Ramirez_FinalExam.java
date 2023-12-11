/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ramirez_tipperapp.ramirez_finalexam;

/**
 *
 * @author angelramirez-rivera
 */
public class Ramirez_FinalExam {

    public static void main(String[] args) {
    Model model = new Model();
    View view = new View();
    Controller controller = new Controller(model, view);
    controller.run();
}

}
