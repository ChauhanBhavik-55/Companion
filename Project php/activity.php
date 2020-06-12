<?php
include('connection.php');
if ($_SERVER['REQUEST_METHOD'] =='POST'){

    $enrollment = $_POST['enrollment'];
    $title = $_POST['title'];
    $fromdate = $_POST['fromdate'];
    $fromtime = $_POST['fromtime'];
    $minutes = $_POST['minutes'];
    $loaction = $_POST['loaction'];
    $discription = $_POST['discription'];
    
    $sql = "INSERT INTO user_activity(enrollment,title,fromdate,fromtime,minutes,location,discription) VALUES ('$enrollment', '$title', '$fromdate','$fromtime','$minutes','$loaction','$discription')";
    if ( mysqli_query($conn, $sql) ) {
        $result["Success"] = "1";
        echo json_encode($result);
      
    }else{
        $result["Success"] = "0";
        echo json_encode($result);
    }


    
    
}

?>