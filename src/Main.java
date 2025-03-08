import java.sql.*;
import java.util.*;

import javax.management.remote.SubjectDelegationPermission;
public class Main {

    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/Interview";
        String username ="root";
        String password="";
        try{Class.forName("com.mysql.cj.jdbc.Driver");
    }catch(ClassNotFoundException e){
        System.out.println(e.getMessage());
    }
    try {
        Connection con = DriverManager.getConnection(url, username, password);
        String query ="insert into Interview(StudentName,CollegeName,Round1Marks,Round2Marks,Round3Marks,TechnicalRoundMarks,Total_Marks,Result,`Rank`) values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        String StudentName;
        String CollegeName;
        do{
            // Scanner sc = new Scanner(System.in);
            System.out.println("enter the name of the Student: ");
            StudentName= sc.nextLine().trim();
            if (StudentName.isEmpty()) {
                System.out.println("the name of the student should not be empty");
            }else if (StudentName.length()>30) {
                System.out.println("the name of the student should not be greater than 30");
            }

        }while(StudentName.isEmpty()|| StudentName.length()>30);

        do{
            
            System.out.println("enter the name of the College: ");
            CollegeName= sc.nextLine().trim();
            if (CollegeName.isEmpty()) {
                System.out.println("the name of the CollegeName should not be empty");
            }else if (CollegeName.length()>50) {
                System.out.println("the name of the CollegeName should not be greater than 50");
            }

        }while(CollegeName.isEmpty()|| CollegeName.length()>30);

        //writing for the other variables using do while 

        double Round1Marks;
        double Round2Marks;
        double Round3Marks;
        
        do{
            System.out.println("Enter the marks for the Round1: ");
            Round1Marks=sc.nextDouble();
            sc.nextLine();
            if (Round1Marks<0) {
                System.out.println("the marks cannot be negative");
            }else if (Round1Marks>10) {
                System.out.println("the marks cannot be greter than 10");
            }
            
        }while (!(Round1Marks>0 || Round1Marks<10)); 

        do {
            System.out.println("Ente the marks for the Round2: ");
            Round2Marks=sc.nextDouble();
            sc.nextLine();
            if (Round2Marks<0) {
                System.out.println("the marks cannot be negative");
            }else if (Round2Marks>10) {
                System.out.println("the marks cannot be greter than 10");
            }
            
        } while (!(Round2Marks>0|| Round2Marks<10));

        do {
            System.out.println("enter the marks for the round3 : ");
            Round3Marks=sc.nextDouble();
            sc.nextLine();
            if (Round3Marks<0) {
                System.out.println("the marks cannot be negative");
            }else if (Round3Marks>10) {
                System.out.println("the marks cannot be greter than 10");
            }
            
        } while (!(Round3Marks>0|| Round3Marks<10));

        double TechnicalRoundMarks;
        do {
            System.out.println("enter the marks for the Technical round : ");
            TechnicalRoundMarks=sc.nextDouble();
            sc.nextLine();
            if (TechnicalRoundMarks<0) {
                System.out.println("the marks cannot be negative");
            }else if (TechnicalRoundMarks>20) {
                System.out.println("the marks cannot be greter than 10");
            }

            
        } while (!(TechnicalRoundMarks<0 || TechnicalRoundMarks<20));

        double Total_Marks= Round1Marks+Round2Marks+Round3Marks+TechnicalRoundMarks;
        double round1percantage= (Round1Marks/10)*100;
        double round2percantage= (Round2Marks/10)*100;
        double round3percantage= (Round3Marks/10)*100;
        double TechnicalRoundMarkspercentage= (TechnicalRoundMarks/20)*100;

            String Result ;
            if (round1percantage<70 || round2percantage<70 || round3percantage<70 || TechnicalRoundMarkspercentage<70) {
               Result="Rejected";
            }else{
                Result="Selected";
            }

            pst.setString(1, StudentName);
            pst.setString(2, CollegeName);
            pst.setDouble(3, Round1Marks);
            pst.setDouble(4, Round2Marks);
            pst.setDouble(5,Round3Marks);
            pst.setDouble(6, TechnicalRoundMarks);
            pst.setDouble(7, Total_Marks);
            pst.setString(8, Result);
            pst.setInt(9, 0);

            pst.addBatch();

        


        // while (true) {
            // Scanner sc = new Scanner(System.in);
            // System.out.print("Enter the name of the Student: ");
            // String StudentName= sc.nextLine();
            // if (StudentName.length()>30) {
            //     System.out.println("error in the name ");
            //     break;
            // }
            // System.out.print("Enter the name of the College: ");
            // String CollegeName= sc.nextLine();
            // if (CollegeName.length()>50) {
            //     System.out.println("error in the name ");
            //     break;
            // }
            // System.out.print("Enter the Round1marks of the Student: ");
            // double Round1Marks = sc.nextDouble();
            // sc.nextLine();
            // if (Round1Marks<0 || Round1Marks>10) {
            //     System.out.println("Enter the proper marks");
            //     break;
            // }
            // System.out.print("Enter the Round2marks of the Student: ");
            // double Round2Marks = sc.nextDouble();
            // sc.nextLine();
            // if (Round2Marks<0 || Round2Marks>10) {
            //     System.out.println("Enter the proper marks");
            //     break;
            // }
            // System.out.print("Enter the Round3marks of the Student: ");
            // double Round3Marks = sc.nextDouble();
            // sc.nextLine();
            // if (Round3Marks<0 || Round3Marks>10) {
            //     System.out.println("Enter the proper marks");
            //     break;
            // }
            // System.out.print("Enter the TechnicalRoundMarks of the Student: ");
            // double TechnicalRoundMarks = sc.nextDouble();
            // sc.nextLine();
            // if (TechnicalRoundMarks<0 || TechnicalRoundMarks>20) {
            //     System.out.println("Enter the proper marks");
            //     break;
            // }

            // double Total_Marks= Round1Marks+Round2Marks+Round3Marks+TechnicalRoundMarks;
            // String Result ;
            // if (Total_Marks>=35) {
            //    Result="Selected";
            // }else{
            //     Result="Rejected";
            // }

    
            // pst.setString(1, StudentName);
            // pst.setString(2, CollegeName);
            // pst.setDouble(3, Round1Marks);
            // pst.setDouble(4, Round2Marks);
            // pst.setDouble(5,Round3Marks);
            // pst.setDouble(6, TechnicalRoundMarks);
            // pst.setDouble(7, Total_Marks);
            // pst.setString(8, Result);
            // pst.setInt(9, 0);

            // pst.addBatch();
        //     System.out.print("Do you want to add the extra Record ? (y/n): ");
        //     String choice=sc.next();
        //     if (choice.toUpperCase().equals("N")) {  
        //         break;
        //     }
        // }
        int[] arr=pst.executeBatch();
        System.out.println("You have entered the "+arr.length+" records");

        String rankQuery = "SELECT StudentName, Total_Marks FROM Interview ORDER BY Total_Marks DESC";
            Statement rankStmt = con.createStatement();
            ResultSet rankRs = rankStmt.executeQuery(rankQuery);

            int rank = 1;
            double prevMarks = -1;
            int rankCounter = 0;

            while (rankRs.next()) {
                String studentName = rankRs.getString("StudentName");
                double totalMarks = rankRs.getDouble("Total_Marks");

                if (totalMarks != prevMarks) {
                    rank = rankCounter + 1;
                }
                rankCounter++;
                String updateRankQuery = "UPDATE Interview SET `Rank` = ? WHERE StudentName = ?";
                PreparedStatement updateRankPst = con.prepareStatement(updateRankQuery);
                updateRankPst.setInt(1, rank);
                updateRankPst.setString(2, studentName);
                updateRankPst.executeUpdate();

                prevMarks = totalMarks;
            }
        

        String query1="select * from Interview ";
        Statement st= con.createStatement();
        ResultSet rs= st.executeQuery(query1);
        while (rs.next()) {
            System.out.println("StudentName: "+rs.getString("StudentName")+" CollegeName: "+rs.getString("CollegeName")+" Round1Marks: "+rs.getDouble("Round1Marks")+" Round2Marks: "+rs.getDouble("Round2Marks")+" Round3Marks:  "+rs.getDouble("Round3Marks")+" TechnicalRoundMarks: "+rs.getDouble("TechnicalRoundMarks")+" Total_Marks: "+ rs.getDouble("Total_Marks")+" Result: "+rs.getString("Result")+" Rank: "+rs.getInt("Rank"));
        }
    } catch (SQLException e) {
       System.out.println(e.getMessage());
    }
    }
}