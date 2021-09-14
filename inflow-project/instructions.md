
#
Create Database inflow;

#
composer install
npm install
php artisan key:generate

php artisan migrate
php artisan db:seed --class=table_schoolnameSeeder
php artisan db:seed --class=SubjectSeeder
php artisan db:seed --class=subjectintake

php artisan db:seed --class=StudentSeeder
