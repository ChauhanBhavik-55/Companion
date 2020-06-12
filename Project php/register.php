<?php
include('connection.php');

if ($_SERVER['REQUEST_METHOD'] =='POST'){

    $enrollment = $_POST['enrollment'];
    $firstname = $_POST['firstname'];
    $lastname = $_POST['lastname'];
    $email = $_POST['email'];
    $password = $_POST['password'];
    $contactNo = $_POST['contactNo'];
    
    // check if this user already exists
    $check_user = mysqli_query($conn,"select * from user_registration where enrollment='$enrollment'");
    if(mysqli_num_rows($check_user) > 0){
        $result["Success"] = "0";
        echo json_encode($result);
    }else{
        $sql = "INSERT INTO user_registration(enrollment,firstname,lastname,email,password,contactNo) VALUES ('$enrollment', '$firstname', '$lastname', '$email', '$password', '$contactNo')";

        if ( mysqli_query($conn, $sql) ) {
            $result["Success"] = "1";
            echo json_encode($result);
            // Sending Mail
            $message = 'Welcome '.$firstname . ' '.$lastname.PHP_EOL.'Thank you for Registering!'; 
            mail($email,"Companion",$message);
            mysqli_close($conn);
            
        } else {
            // $result["success"] = "0";
            // $result["message"] = "error";
            echo json_encode($result);
            mysqli_close($conn);
        }
    }


    
    
}

?>