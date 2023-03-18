  <?php
        if (isset($_GET['layout'])) {
            switch ($_GET['layout']) {
                case 'them':
                    require_once 'them.php';
                    break;
                  case 'xoa':
                    require_once 'xoa.php';
                    break;
                  case 'sua':
                    require_once 'sua.php';
                    break;
                default :
                    require_once 'admin.php';
                    break;
            }
        }
        else{
              require_once 'admin.php';
        }
        ?>

