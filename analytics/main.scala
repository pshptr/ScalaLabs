import org.apache.commons.math3.optim.linear._
import org.apache.commons.math3.optim.linear.LinearConstraint
import java.util.ArrayList
import org.apache.commons.math3.optim.linear.Relationship
import org.apache.commons.math3.optim.PointValuePair
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType

object Main23 {
	def main(args:Array[String]):Unit = {
		// create a constraint: 2x + 3y <= 4
		val coeffs: Array[Double] = Array(2.0, 3.0)
		val coeffs2: Array[Double] = Array(1.0, 3.0) // задаются для целевой ф-ии
		val coeffs3: Array[Double] = Array(1.0, 2.0)
		val relationship: Relationship = Relationship.LEQ // задаёт отношения
		val value: Double = 4.0
		val coeffs1: Array[Double] = Array(-1.0, 3.0)
		val relationship2: Relationship = Relationship.GEQ
		val relationship3: Relationship = Relationship.GEQ
		val value2: Double = 1.0
		val value3: Double = 4.0
		val objectiveFunction = new LinearObjectiveFunction(coeffs2, 0.0)
		val constraint: LinearConstraint = new LinearConstraint(coeffs, relationship, value)
		val constraint2: LinearConstraint = new LinearConstraint(coeffs1, relationship2, value2)
		val constraint3: LinearConstraint = new LinearConstraint(coeffs3, relationship3, value3)

		// Solve the optimization
		val solver = new SimplexSolver() // симплекс-метод

		val constraintsList2: java.util.List[LinearConstraint] = new ArrayList[LinearConstraint]()
		constraintsList2.add(constraint)
		constraintsList2.add(constraint2)
		constraintsList2.add(constraint3)
		val result: PointValuePair = solver.optimize(objectiveFunction, new LinearConstraintSet(constraintsList2), GoalType.MINIMIZE)  // указывается целевая функция, 																		      //линейные ограничения, тип целевой 																	     // функции - направлена на минимум
 		// Print the solution
		println(s"Minimum value: ${result.getValue}") // это результат целевой функции, в итоге выводит это в точке оптимума
		println(s"Solution: ${result.getPoint.mkString(",")}") // значения переменных в точке оптимума
		println("good")
	}
}