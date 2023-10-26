import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.{JButton, JFrame, JPanel, SwingUtilities}
import java.awt.Dimension
import javax.swing.{JFrame, JLabel,JTextField, JPanel, SwingUtilities}
import java.sql.{Connection, DriverManager, ResultSet}
import java.awt.Color



object ButtonModule {
  val frame = new JFrame("My Application")
  frame.setSize(680, 400)
  frame.setLayout(null)

  def main(args: Array[String]): Unit = {
    SwingUtilities.invokeLater(() => {
      val productLabel = new JLabel("Product")
      val priceLabel = new JLabel("Price")
      val countLabel = new JLabel("Count")
      val moreThanLabel = new JLabel("More than (price)")
      productLabel.setBounds(20, 120, 130, 20)
      priceLabel.setBounds(160, 120, 130, 20)
      countLabel.setBounds(300, 120, 130, 20)
      moreThanLabel.setBounds(440, 120, 200, 20)


      val insertButton = new JButton("Insert")
      val selectButton = new JButton("Select")
      val getMaxButton = new JButton("Get max")
      val getMoreThanButton = new JButton("Get more than (price)")
      insertButton.setBounds(20, 80, 130, 20)
      selectButton.setBounds(160, 80, 130, 20)
      getMaxButton.setBounds(300, 80, 130, 20)
      getMoreThanButton.setBounds(440, 80, 200, 20)

      val productField = new JTextField(20)
      val priceField = new JTextField(20)
      val countField = new JTextField(20)
      val moreThanField = new JTextField(20)
      productField.setBounds(20, 150, 130, 20)
      priceField.setBounds(160, 150, 130, 20)
      countField.setBounds(300, 150, 130, 20)
      moreThanField.setBounds(440, 150, 200, 20)

      frame.add(insertButton)
      frame.add(selectButton)
      frame.add(getMaxButton)
      frame.add(getMoreThanButton)

      frame.add(productLabel)
      frame.add(priceLabel)
      frame.add(countLabel)
      frame.add(moreThanLabel)

      frame.add(productField)
      frame.add(priceField)
      frame.add(countField)
      frame.add(moreThanField)

      insertButton.addActionListener(new ActionListener{
        override def actionPerformed(e: ActionEvent): Unit = {
          val url = "jdbc:mysql://localhost:3306/scaladb"
          val username = "root"
          val password = "123"

          Class.forName("org.gjt.mm.mysql.Driver")

          val connection = DriverManager.getConnection(url, username, password)

          try{
            val statement = connection.createStatement()
            val rs = statement.execute("INSERT INTO products VALUES ('" + productField.getText() + "'," + priceField.getText() + "," + countField.getText() + ")")
            productField.setText("")
            priceField.setText("")
            countField.setText("")
          }
          finally{
            connection.close()
          }
        }
      })

      selectButton.addActionListener(new ActionListener{
        override def actionPerformed(e: ActionEvent): Unit = {
          val url = "jdbc:mysql://localhost:3306/scaladb"
          val username = "root"
          val password = "123"

          Class.forName("org.gjt.mm.mysql.Driver")

          val connection = DriverManager.getConnection(url, username, password)
          try{
            val statement = connection.createStatement()
            val rs = statement.executeQuery("SELECT * FROM products")

            println("Products:")
            while(rs.next()){
              val product = rs.getString("product")
              val price = rs.getInt("price")
              val count = rs.getInt("count")
              println(s"name=$product, price=$price, count=$count")
            }
            println("")
          }
          finally{
            connection.close()
          }
        }
      })

      getMoreThanButton.addActionListener(new ActionListener{
        override def actionPerformed(e: ActionEvent): Unit = {
          val url = "jdbc:mysql://localhost:3306/scaladb"
          val username = "root"
          val password = "123"

          Class.forName("org.gjt.mm.mysql.Driver")

          val connection = DriverManager.getConnection(url, username, password)
          try{
            val statement = connection.createStatement()
            val minPrice = moreThanField.getText().toString().trim()
            val rs = statement.executeQuery("SELECT * FROM products WHERE price > " + minPrice)

            println("Products with price more than " + minPrice + ":")
            while(rs.next()){
              val product = rs.getString("product")
              val price = rs.getInt("price")
              val count = rs.getInt("count")
              println(s"name=$product, price=$price, count=$count")
            }
            println("")
            moreThanField.setText("")
          }
          finally{
            connection.close()
          }
        }
      })

      getMaxButton.addActionListener(new ActionListener{
        override def actionPerformed(e: ActionEvent): Unit = {
          val url = "jdbc:mysql://localhost:3306/scaladb"
          val username = "root"
          val password = "123"

          Class.forName("org.gjt.mm.mysql.Driver")

          val connection = DriverManager.getConnection(url, username, password)
          try{
            val statement = connection.createStatement()
            val rs1 = statement.executeQuery("SELECT MAX(price * count) AS m FROM products")

            var max: Int = 0
            while(rs1.next()){
              max = rs1.getInt("m")
            }

            val rs = statement.executeQuery("SELECT * FROM products WHERE price * count = " + max)

            println("Max price * count:")
            while(rs.next()){
              val product = rs.getString("product")
              val price = rs.getInt("price")
              val count = rs.getInt("count")
              println(s"name=$product, price=$price, count=$count")
            }
            println("")
          }
          finally{
            connection.close()
          }
        }
      })

      frame.setBackground(Color.BLUE)
      frame.setLocationRelativeTo(null)
      frame.setVisible(true)

    })
  }
}
