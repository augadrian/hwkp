var gulp = require('gulp');
//var sass = require('gulp-ruby-sass');
// var uglify = require('gulp-uglify');
// var rename = require('gulp-rename');
// var concat = require('gulp-concat');
var browserSync = require('browser-sync').create();

// gulp.task('jsmin', function () {
//     gulp.src(['admin/js/app.js'])
//         .pipe(uglify({
//             mangle: true,//类型：Boolean 默认：true 是否修改变量名
//             mangle: {except: ['require' ,'exports' ,'module' ,'$']}//排除混淆关键字
//         }))
//         .pipe(gulp.dest('dist/js'));
// });

// gulp.task('javascript', function() {
//     gulp.src('admin/js/*.js')
//         .pipe(sourcemaps.init())
//         .pipe(sourcemaps.write())
//         .pipe(gulp.dest('dist'));
// });

// var jsFiles = [
//     'admin/js/app.js',
//     'admin/js/router.js'
// ];
//
// var globalJSFiles=[
//     'static/js/lib/jquery/jquery.min.js',
//     'static/js/lib/ionic-angular.min.js',
//     'static/js/lib/angular/angular-material.min.js',
//     'static/js/lib/angular/angular-animate.min.js',
//     'static/js/lib/angular/angular-messages.min.js',
//     'static/js/lib/angular/angular-aria.min.js',
//     'static/js/lib/angular/angular-perfect-scrollbar.js',
//     'static/js/lib/angular/angular-use-form-error.js',
//     'static/js/lib/moment-with-locales.js',
//     'static/js/lib/moment-with-locales.js'
// ]
// gulp.task('globalJS', function() {
//     return gulp.src(globalJSFiles)
//         .pipe(concat('global.js'))
//         .pipe(gulp.dest('dist/js'))
//         .pipe(rename('global.min.js'))
//         .pipe(uglify({
//             mangle: true,
//             mangle: {except: ['require' ,'exports' ,'module' ,'$']}
//         }))
//         .pipe(gulp.dest('dist/js'));
// })

gulp.task('server', function() {
    // browserSync.init({
    //     server: ""
    // });
    browserSync.init({
        proxy: "localhost:8080",    //apache或iis等代理地址
        notify: true,              //刷新是否提示
        open: true                //是否自动打开页面
    });
    gulp.watch([                    //监听文件变化数组
        '**/*.html',
        'statics/js/*.js',
        'statics/css/*.css'
    ]).on("change", browserSync.reload);
});