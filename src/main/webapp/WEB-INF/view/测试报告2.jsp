<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8"> <!-- for HTML5 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>测试报告222</title>
    <link href="webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="webjars/bootstrap/css/font-awesome.min.css" rel="stylesheet">
    <link href="webjars/bootstrap/css/animate.min.css" rel="stylesheet">
    <link href="webjars/bootstrap/css/chosen.css" rel="stylesheet">
    <base target="_blank">
    <style type="text/css">
        h1, h2, h3, h4, h5, h6 {
            font-weight: 100
        }

        h1 {
            font-size: 30px
        }

        h2 {
            font-size: 24px
        }

        h3 {
            font-size: 16px
        }

        h4 {
            font-size: 14px
        }

        h5 {
            font-size: 12px
        }

        h6 {
            font-size: 10px
        }

        h3, h4, h5 {
            margin-top: 5px;
            font-weight: 600
        }

        a:focus {
            outline: 0
        }

        .nav > li > a {
            color: #a7b1c2;
            font-weight: 600;
            padding: 14px 20px 14px 25px
        }

        .nav li > a {
            display: block
        }

        .nav.navbar-right > li > a {
            color: #999c9e
        }

        .nav > li.active > a {
            color: #fff
        }

        .navbar-default .nav > li > a:focus, .navbar-default .nav > li > a:hover {
            background-color: #293846;
            color: #fff
        }

        .nav .open > a, .nav .open > a:focus, .nav .open > a:hover {
            background: #fff
        }

        .nav > li > a i {
            margin-right: 6px
        }

        .navbar {
            border: 0
        }

        .navbar-default {
            background-color: transparent;
            border-color: #2f4050;
            position: relative
        }

        .navbar-top-links li {
            display: inline-block
        }

        .navbar-top-links li:last-child {
            margin-right: 30px
        }

        body.body-small .navbar-top-links li:last-child {
            margin-right: 10px
        }

        .navbar-top-links li a {
            padding: 20px 10px;
            min-height: 50px
        }

        .dropdown-menu {
            border: medium none;
            display: none;
            float: left;
            font-size: 12px;
            left: 0;
            list-style: none outside none;
            padding: 0;
            position: absolute;
            text-shadow: none;
            top: 100%;
            z-index: 1000;
            border-radius: 0;
            box-shadow: 0 0 3px rgba(86, 96, 117, .3)
        }

        .dropdown-menu > li > a {
            border-radius: 3px;
            color: inherit;
            line-height: 25px;
            margin: 4px;
            text-align: left;
            font-weight: 400
        }

        .dropdown-menu > li > a.font-bold {
            font-weight: 600
        }

        .navbar-top-links .dropdown-menu li {
            display: block
        }

        .navbar-top-links .dropdown-menu li:last-child {
            margin-right: 0
        }

        .navbar-top-links .dropdown-menu li a {
            padding: 3px 20px;
            min-height: 0
        }

        .navbar-top-links .dropdown-menu li a div {
            white-space: normal
        }

        .navbar-top-links .dropdown-alerts, .navbar-top-links .dropdown-messages, .navbar-top-links .dropdown-tasks {
            width: 310px;
            min-width: 0
        }

        .navbar-top-links .dropdown-messages {
            margin-left: 5px
        }

        .navbar-top-links .dropdown-tasks {
            margin-left: -59px
        }

        .navbar-top-links .dropdown-alerts {
            margin-left: -123px
        }

        .navbar-top-links .dropdown-user {
            right: 0;
            left: auto
        }

        .dropdown-alerts, .dropdown-messages {
            padding: 10px
        }

        .dropdown-alerts li a, .dropdown-messages li a {
            font-size: 12px
        }

        .dropdown-alerts li em, .dropdown-messages li em {
            font-size: 10px
        }

        .nav.navbar-top-links .dropdown-alerts a {
            font-size: 12px
        }

        .nav-header {
            padding: 33px 25px;
            background: url(patterns/header-profile.png) no-repeat
        }

        .nav > li.active {
            border-left: 4px solid #19aa8d;
            background: #293846
        }

        .nav.nav-second-level > li.active {
            border: none
        }

        .nav.nav-second-level.collapse[style] {
            height: auto !important
        }

        .nav-header a {
            color: #DFE4ED
        }

        .nav-header .text-muted {
            color: #8095a8
        }

        .minimalize-styl-2 {
            padding: 4px 12px;
            margin: 14px 5px 5px 20px;
            font-size: 14px;
            float: left
        }

        .navbar-form-custom {
            float: left;
            height: 50px;
            padding: 0;
            width: 200px;
            display: inline-table
        }

        .navbar-form-custom .form-group {
            margin-bottom: 0
        }

        .nav.navbar-top-links a {
            font-size: 14px
        }

        .navbar-form-custom .form-control {
            background: none repeat scroll 0 0 rgba(0, 0, 0, 0);
            border: medium none;
            font-size: 14px;
            height: 60px;
            margin: 0;
            z-index: 2000
        }

        .count-info .label {
            line-height: 12px;
            padding: 1px 5px;
            position: absolute;
            right: 6px;
            top: 12px
        }

        .arrow {
            float: right;
            margin-top: 2px
        }

        .fa.arrow:before {
            content: "\f104"
        }

        .active > a > .fa.arrow:before {
            content: "\f107"
        }

        .nav-second-level li, .nav-third-level li {
            border-bottom: none !important
        }

        .nav-second-level li a {
            padding: 7px 15px 7px 10px;
            padding-left: 52px
        }

        .nav-third-level li a {
            padding-left: 62px
        }

        .nav-second-level li:last-child {
            margin-bottom: 10px
        }

        .mini-navbar .nav li:focus > .nav-second-level, body:not(.fixed-sidebar):not(.canvas-menu).mini-navbar .nav li:hover > .nav-second-level {
            display: block;
            border-radius: 0 2px 2px 0;
            min-width: 140px;
            height: auto
        }

        body.mini-navbar .navbar-default .nav > li > .nav-second-level li a {
            font-size: 12px;
            border-radius: 0 2px 2px 0
        }

        .fixed-nav .slimScrollDiv #side-menu {
            padding-bottom: 60px;
            position: relative
        }

        .slimScrollDiv > * {
            overflow: hidden
        }

        .mini-navbar .nav-second-level li a {
            padding: 10px 10px 10px 15px
        }

        .canvas-menu.mini-navbar .nav-second-level {
            background: #293846
        }

        .mini-navbar li.active .nav-second-level {
            left: 65px
        }

        .navbar-default .special_link a {
            background: #1ab394;
            color: #fff
        }

        .navbar-default .special_link a:hover {
            background: #17987e !important;
            color: #fff
        }

        .navbar-default .special_link a span.label {
            background: #fff;
            color: #1ab394
        }

        .navbar-default .landing_link a {
            background: #1cc09f;
            color: #fff
        }

        .navbar-default .landing_link a:hover {
            background: #1ab394 !important;
            color: #fff
        }

        .navbar-default .landing_link a span.label {
            background: #fff;
            color: #1cc09f
        }

        .logo-element {
            text-align: center;
            font-size: 18px;
            font-weight: 600;
            color: #fff;
            display: none;
            padding: 18px 0
        }

        .pace-done #page-wrapper, .pace-done .footer, .pace-done .nav-header, .pace-done .navbar-static-side, .pace-done li.active {
            -webkit-transition: all .5s;
            transition: all .5s
        }

        .navbar-fixed-top {
            -webkit-transition-duration: .5s;
            transition-duration: .5s;
            z-index: 2030
        }

        .navbar-fixed-top, .navbar-static-top {
            background: #f3f3f4
        }

        .fixed-nav #wrapper {
            padding-top: 60px;
            box-sizing: border-box
        }

        .fixed-nav .minimalize-styl-2 {
            margin: 14px 5px 5px 15px
        }

        .body-small .navbar-fixed-top {
            margin-left: 0
        }

        body.mini-navbar .navbar-static-side {
            width: 70px
        }

        body.mini-navbar .nav-label, body.mini-navbar .navbar-default .nav li a span, body.mini-navbar .profile-element {
            display: none
        }

        body.canvas-menu .profile-element {
            display: block
        }

        body:not(.fixed-sidebar):not(.canvas-menu).mini-navbar .nav-second-level {
            display: none
        }

        body.mini-navbar .navbar-default .nav > li > a {
            font-size: 16px
        }

        body.mini-navbar .logo-element {
            display: block
        }

        body.canvas-menu .logo-element {
            display: none
        }

        body.mini-navbar .nav-header {
            padding: 0;
            background-color: #1ab394
        }

        body.canvas-menu .nav-header {
            padding: 33px 25px
        }

        body.mini-navbar #page-wrapper {
            margin: 0 0 0 70px
        }

        body.canvas-menu.mini-navbar #page-wrapper, body.canvas-menu.mini-navbar .footer {
            margin: 0
        }

        body.canvas-menu .navbar-static-side, body.fixed-sidebar .navbar-static-side {
            position: fixed;
            width: 220px;
            z-index: 2001;
            height: 100%
        }

        body.fixed-sidebar.mini-navbar .navbar-static-side {
            width: 70px
        }

        body.body-small.fixed-sidebar.mini-navbar #page-wrapper, body.fixed-sidebar.mini-navbar #page-wrapper {
            margin: 0 0 0 70px
        }

        body.body-small.fixed-sidebar.mini-navbar .navbar-static-side {
            width: 70px
        }

        .fixed-sidebar.mini-navbar .nav li > .nav-second-level {
            display: none
        }

        .fixed-sidebar.mini-navbar .nav li.active {
            border-left-width: 0
        }

        .canvas-menu.mini-navbar .nav li:hover > .nav-second-level, .fixed-sidebar.mini-navbar .nav li:hover > .nav-second-level {
            position: absolute;
            left: 70px;
            top: 0;
            background-color: #2f4050;
            padding: 10px 10px 0;
            font-size: 12px;
            display: block;
            min-width: 140px;
            border-radius: 2px
        }

        body.fixed-sidebar.mini-navbar .navbar-default .nav > li > .nav-second-level li a {
            font-size: 12px;
            border-radius: 3px
        }

        body.canvas-menu.mini-navbar .navbar-default .nav > li > .nav-second-level li a {
            font-size: 13px;
            border-radius: 3px
        }

        .canvas-menu.mini-navbar .nav-second-level li a, .fixed-sidebar.mini-navbar .nav-second-level li a {
            padding: 10px 10px 10px 15px
        }

        .canvas-menu.mini-navbar .nav-second-level, .fixed-sidebar.mini-navbar .nav-second-level {
            position: relative;
            padding: 0;
            font-size: 13px
        }

        .canvas-menu.mini-navbar li.active .nav-second-level, .fixed-sidebar.mini-navbar li.active .nav-second-level {
            left: 0
        }

        body.canvas-menu nav.navbar-static-side {
            z-index: 2001;
            background: #2f4050;
            height: 100%;
            position: fixed;
            display: none
        }

        body.canvas-menu.mini-navbar nav.navbar-static-side {
            display: block;
            width: 70px
        }

        .top-navigation #page-wrapper {
            margin-left: 0
        }

        .top-navigation .navbar-nav .dropdown-menu > .active > a {
            background: #fff;
            color: #1ab394;
            font-weight: 700
        }

        .white-bg .navbar-fixed-top, .white-bg .navbar-static-top {
            background: #fff
        }

        .top-navigation .navbar {
            margin-bottom: 0
        }

        .top-navigation .nav > li > a {
            padding: 15px 20px;
            color: #676a6c
        }

        .top-navigation .nav > li a:focus, .top-navigation .nav > li a:hover {
            background: #fff;
            color: #1ab394
        }

        .top-navigation .nav > li.active {
            background: #fff;
            border: none
        }

        .top-navigation .nav > li.active > a {
            color: #1ab394
        }

        .top-navigation .navbar-right {
            padding-right: 10px
        }

        .top-navigation .navbar-nav .dropdown-menu {
            box-shadow: none;
            border: 1px solid #e7eaec
        }

        .top-navigation .dropdown-menu > li > a {
            margin: 0;
            padding: 7px 20px
        }

        .navbar .dropdown-menu {
            margin-top: 0
        }

        .top-navigation .navbar-brand {
            background: #1ab394;
            color: #fff;
            padding: 15px 25px
        }

        .top-navigation .navbar-top-links li:last-child {
            margin-right: 0
        }

        .body-small.fixed-sidebar.mini-navbar .top-navigation #page-wrapper, .canvas-menu #page-wrapper, .mini-navbar .top-navigation #page-wrapper, .top-navigation.body-small.fixed-sidebar.mini-navbar #page-wrapper, .top-navigation.mini-navbar #page-wrapper {
            margin: 0
        }

        .fixed-nav #wrapper.top-navigation, .top-navigation.fixed-nav #wrapper {
            margin-top: 50px
        }

        .top-navigation .footer.fixed {
            margin-left: 0 !important
        }

        .top-navigation .wrapper.wrapper-content {
            padding: 40px
        }

        .body-small .top-navigation .wrapper.wrapper-content, .top-navigation.body-small .wrapper.wrapper-content {
            padding: 40px 0
        }

        .navbar-toggle {
            color: #fff;
            padding: 6px 12px;
            font-size: 14px
        }

        .top-navigation .navbar-nav .open .dropdown-menu .dropdown-header, .top-navigation .navbar-nav .open .dropdown-menu > li > a {
            padding: 10px 15px 10px 20px
        }

        @media (max-width: 768px) {
            .top-navigation .navbar-header {
                display: block;
                float: none
            }
        }

        .menu-visible-lg, .menu-visible-md {
            display: none !important
        }

        @media (min-width: 1200px) {
            .menu-visible-lg {
                display: block !important
            }
        }

        @media (min-width: 992px) {
            .menu-visible-md {
                display: block !important
            }
        }

        @media (max-width: 767px) {
            .menu-visible-lg, .menu-visible-md {
                display: block !important
            }
        }

        .btn {
            border-radius: 3px
        }

        .float-e-margins .btn {
            margin-bottom: 5px
        }

        .btn-w-m {
            min-width: 120px
        }

        .btn-primary.btn-outline {
            color: #1ab394
        }

        .btn-success.btn-outline {
            color: #1c84c6
        }

        .btn-info.btn-outline {
            color: #23c6c8
        }

        .btn-warning.btn-outline {
            color: #f8ac59
        }

        .btn-danger.btn-outline {
            color: #ed5565
        }

        .btn-danger.btn-outline:hover, .btn-info.btn-outline:hover, .btn-primary.btn-outline:hover, .btn-success.btn-outline:hover, .btn-warning.btn-outline:hover {
            color: #fff
        }

        .btn-primary {
            background-color: #1ab394;
            border-color: #1ab394;
            color: #FFF
        }

        .btn-primary.active, .btn-primary:active, .btn-primary:focus, .btn-primary:hover, .open .dropdown-toggle.btn-primary {
            background-color: #18a689;
            border-color: #18a689;
            color: #FFF
        }

        .btn-primary.active, .btn-primary:active, .open .dropdown-toggle.btn-primary {
            background-image: none
        }

        .btn-primary.active[disabled], .btn-primary.disabled, .btn-primary.disabled.active, .btn-primary.disabled:active, .btn-primary.disabled:focus, .btn-primary.disabled:hover, .btn-primary[disabled], .btn-primary[disabled]:active, .btn-primary[disabled]:focus, .btn-primary[disabled]:hover, fieldset[disabled] .btn-primary, fieldset[disabled] .btn-primary.active, fieldset[disabled] .btn-primary:active, fieldset[disabled] .btn-primary:focus, fieldset[disabled] .btn-primary:hover {
            background-color: #1dc5a3;
            border-color: #1dc5a3
        }

        .btn-success {
            background-color: #1c84c6;
            border-color: #1c84c6;
            color: #FFF
        }

        .btn-success.active, .btn-success:active, .btn-success:focus, .btn-success:hover, .open .dropdown-toggle.btn-success {
            background-color: #1a7bb9;
            border-color: #1a7bb9;
            color: #FFF
        }

        .btn-success.active, .btn-success:active, .open .dropdown-toggle.btn-success {
            background-image: none
        }

        .btn-success.active[disabled], .btn-success.disabled, .btn-success.disabled.active, .btn-success.disabled:active, .btn-success.disabled:focus, .btn-success.disabled:hover, .btn-success[disabled], .btn-success[disabled]:active, .btn-success[disabled]:focus, .btn-success[disabled]:hover, fieldset[disabled] .btn-success, fieldset[disabled] .btn-success.active, fieldset[disabled] .btn-success:active, fieldset[disabled] .btn-success:focus, fieldset[disabled] .btn-success:hover {
            background-color: #1f90d8;
            border-color: #1f90d8
        }

        .btn-info {
            background-color: #23c6c8;
            border-color: #23c6c8;
            color: #FFF
        }

        .btn-info.active, .btn-info:active, .btn-info:focus, .btn-info:hover, .open .dropdown-toggle.btn-info {
            background-color: #21b9bb;
            border-color: #21b9bb;
            color: #FFF
        }

        .btn-info.active, .btn-info:active, .open .dropdown-toggle.btn-info {
            background-image: none
        }

        .btn-info.active[disabled], .btn-info.disabled, .btn-info.disabled.active, .btn-info.disabled:active, .btn-info.disabled:focus, .btn-info.disabled:hover, .btn-info[disabled], .btn-info[disabled]:active, .btn-info[disabled]:focus, .btn-info[disabled]:hover, fieldset[disabled] .btn-info, fieldset[disabled] .btn-info.active, fieldset[disabled] .btn-info:active, fieldset[disabled] .btn-info:focus, fieldset[disabled] .btn-info:hover {
            background-color: #26d7d9;
            border-color: #26d7d9
        }

        .btn-default {
            background-color: #c2c2c2;
            border-color: #c2c2c2;
            color: #FFF
        }

        .btn-default.active, .btn-default:active, .btn-default:focus, .btn-default:hover, .open .dropdown-toggle.btn-default {
            background-color: #bababa;
            border-color: #bababa;
            color: #FFF
        }

        .btn-default.active, .btn-default:active, .open .dropdown-toggle.btn-default {
            background-image: none
        }

        .btn-default.active[disabled], .btn-default.disabled, .btn-default.disabled.active, .btn-default.disabled:active, .btn-default.disabled:focus, .btn-default.disabled:hover, .btn-default[disabled], .btn-default[disabled]:active, .btn-default[disabled]:focus, .btn-default[disabled]:hover, fieldset[disabled] .btn-default, fieldset[disabled] .btn-default.active, fieldset[disabled] .btn-default:active, fieldset[disabled] .btn-default:focus, fieldset[disabled] .btn-default:hover {
            background-color: #ccc;
            border-color: #ccc
        }

        .btn-warning {
            background-color: #f8ac59;
            border-color: #f8ac59;
            color: #FFF
        }

        .btn-warning.active, .btn-warning:active, .btn-warning:focus, .btn-warning:hover, .open .dropdown-toggle.btn-warning {
            background-color: #f7a54a;
            border-color: #f7a54a;
            color: #FFF
        }

        .btn-warning.active, .btn-warning:active, .open .dropdown-toggle.btn-warning {
            background-image: none
        }

        .btn-warning.active[disabled], .btn-warning.disabled, .btn-warning.disabled.active, .btn-warning.disabled:active, .btn-warning.disabled:focus, .btn-warning.disabled:hover, .btn-warning[disabled], .btn-warning[disabled]:active, .btn-warning[disabled]:focus, .btn-warning[disabled]:hover, fieldset[disabled] .btn-warning, fieldset[disabled] .btn-warning.active, fieldset[disabled] .btn-warning:active, fieldset[disabled] .btn-warning:focus, fieldset[disabled] .btn-warning:hover {
            background-color: #f9b66d;
            border-color: #f9b66d
        }

        .btn-danger {
            background-color: #ed5565;
            border-color: #ed5565;
            color: #FFF
        }

        .btn-danger.active, .btn-danger:active, .btn-danger:focus, .btn-danger:hover, .open .dropdown-toggle.btn-danger {
            background-color: #ec4758;
            border-color: #ec4758;
            color: #FFF
        }

        .btn-danger.active, .btn-danger:active, .open .dropdown-toggle.btn-danger {
            background-image: none
        }

        .btn-danger.active[disabled], .btn-danger.disabled, .btn-danger.disabled.active, .btn-danger.disabled:active, .btn-danger.disabled:focus, .btn-danger.disabled:hover, .btn-danger[disabled], .btn-danger[disabled]:active, .btn-danger[disabled]:focus, .btn-danger[disabled]:hover, fieldset[disabled] .btn-danger, fieldset[disabled] .btn-danger.active, fieldset[disabled] .btn-danger:active, fieldset[disabled] .btn-danger:focus, fieldset[disabled] .btn-danger:hover {
            background-color: #ef6776;
            border-color: #ef6776
        }

        .btn-link {
            color: inherit
        }

        .btn-link.active, .btn-link:active, .btn-link:focus, .btn-link:hover, .open .dropdown-toggle.btn-link {
            color: #1ab394;
            text-decoration: none
        }

        .btn-link.active, .btn-link:active, .open .dropdown-toggle.btn-link {
            background-image: none
        }

        .btn-link.active[disabled], .btn-link.disabled, .btn-link.disabled.active, .btn-link.disabled:active, .btn-link.disabled:focus, .btn-link.disabled:hover, .btn-link[disabled], .btn-link[disabled]:active, .btn-link[disabled]:focus, .btn-link[disabled]:hover, fieldset[disabled] .btn-link, fieldset[disabled] .btn-link.active, fieldset[disabled] .btn-link:active, fieldset[disabled] .btn-link:focus, fieldset[disabled] .btn-link:hover {
            color: #cacaca
        }

        .btn-white {
            color: inherit;
            background: #fff;
            border: 1px solid #e7eaec
        }

        .btn-white.active, .btn-white:active, .btn-white:focus, .btn-white:hover, .open .dropdown-toggle.btn-white {
            color: inherit;
            border: 1px solid #d2d2d2
        }

        .btn-white.active, .btn-white:active {
            box-shadow: 0 2px 5px rgba(0, 0, 0, .15) inset
        }

        .btn-white.active, .btn-white:active, .open .dropdown-toggle.btn-white {
            background-image: none
        }

        .btn-white.active[disabled], .btn-white.disabled, .btn-white.disabled.active, .btn-white.disabled:active, .btn-white.disabled:focus, .btn-white.disabled:hover, .btn-white[disabled], .btn-white[disabled]:active, .btn-white[disabled]:focus, .btn-white[disabled]:hover, fieldset[disabled] .btn-white, fieldset[disabled] .btn-white.active, fieldset[disabled] .btn-white:active, fieldset[disabled] .btn-white:focus, fieldset[disabled] .btn-white:hover {
            color: #cacaca
        }

        .form-control, .form-control:focus, .has-error .form-control:focus, .has-success .form-control:focus, .has-warning .form-control:focus, .navbar-collapse, .navbar-form, .navbar-form-custom .form-control:focus, .navbar-form-custom .form-control:hover, .open .btn.dropdown-toggle, .panel, .popover, .progress, .progress-bar {
            box-shadow: none
        }

        .btn-outline {
            color: inherit;
            background-color: transparent;
            -webkit-transition: all .5s;
            transition: all .5s
        }

        .btn-rounded {
            border-radius: 50px
        }

        .btn-large-dim {
            width: 90px;
            height: 90px;
            font-size: 42px
        }

        button.dim {
            display: inline-block;
            color: #fff;
            text-decoration: none;
            text-transform: uppercase;
            text-align: center;
            padding-top: 6px;
            margin-right: 10px;
            position: relative;
            cursor: pointer;
            border-radius: 5px;
            font-weight: 600;
            margin-bottom: 20px !important
        }

        button.dim:active {
            top: 3px
        }

        button.btn-primary.dim {
            box-shadow: inset 0 0 0 #16987e, 0 5px 0 0 #16987e, 0 10px 5px #999
        }

        button.btn-primary.dim:active {
            box-shadow: inset 0 0 0 #16987e, 0 2px 0 0 #16987e, 0 5px 3px #999
        }

        button.btn-default.dim {
            box-shadow: inset 0 0 0 #b3b3b3, 0 5px 0 0 #b3b3b3, 0 10px 5px #999
        }

        button.btn-default.dim:active {
            box-shadow: inset 0 0 0 #b3b3b3, 0 2px 0 0 #b3b3b3, 0 5px 3px #999
        }

        button.btn-warning.dim {
            box-shadow: inset 0 0 0 #f79d3c, 0 5px 0 0 #f79d3c, 0 10px 5px #999
        }

        button.btn-warning.dim:active {
            box-shadow: inset 0 0 0 #f79d3c, 0 2px 0 0 #f79d3c, 0 5px 3px #999
        }

        button.btn-info.dim {
            box-shadow: inset 0 0 0 #1eacae, 0 5px 0 0 #1eacae, 0 10px 5px #999
        }

        button.btn-info.dim:active {
            box-shadow: inset 0 0 0 #1eacae, 0 2px 0 0 #1eacae, 0 5px 3px #999
        }

        button.btn-success.dim {
            box-shadow: inset 0 0 0 #1872ab, 0 5px 0 0 #1872ab, 0 10px 5px #999
        }

        button.btn-success.dim:active {
            box-shadow: inset 0 0 0 #1872ab, 0 2px 0 0 #1872ab, 0 5px 3px #999
        }

        button.btn-danger.dim {
            box-shadow: inset 0 0 0 #ea394c, 0 5px 0 0 #ea394c, 0 10px 5px #999
        }

        button.btn-danger.dim:active {
            box-shadow: inset 0 0 0 #ea394c, 0 2px 0 0 #ea394c, 0 5px 3px #999
        }

        button.dim:before {
            font-size: 50px;
            line-height: 1em;
            font-weight: 400;
            color: #fff;
            display: block;
            padding-top: 10px
        }

        button.dim:active:before {
            top: 7px;
            font-size: 50px
        }

        .label {
            background-color: #d1dade;
            color: #5e5e5e;
            font-size: 10px;
            font-weight: 600;
            padding: 3px 8px;
            text-shadow: none
        }

        .badge {
            background-color: #d1dade;
            color: #5e5e5e;
            font-size: 11px;
            font-weight: 600;
            padding-bottom: 4px;
            padding-left: 6px;
            padding-right: 6px;
            text-shadow: none
        }

        .badge-primary, .label-primary {
            background-color: #1ab394;
            color: #FFF
        }

        .badge-success, .label-success {
            background-color: #1c84c6;
            color: #FFF
        }

        .badge-warning, .label-warning {
            background-color: #f8ac59;
            color: #FFF
        }

        .badge-warning-light, .label-warning-light {
            background-color: #f8ac59;
            color: #fff
        }

        .badge-danger, .label-danger {
            background-color: #ed5565;
            color: #FFF
        }

        .badge-info, .label-info {
            background-color: #23c6c8;
            color: #FFF
        }

        .badge-inverse, .label-inverse {
            background-color: #262626;
            color: #FFF
        }

        .badge-white, .label-white {
            background-color: #FFF;
            color: #5E5E5E
        }

        .badge-disable, .label-white {
            background-color: #2A2E36;
            color: #8B91A0
        }

        .chosen-container-single .chosen-single {
            background: #fff;
            box-shadow: none;
            -moz-box-sizing: border-box;
            background-color: #FFF;
            border: 1px solid #CBD5DD;
            border-radius: 2px;
            cursor: text;
            height: auto !important;
            margin: 0;
            min-height: 30px;
            overflow: hidden;
            padding: 4px 12px;
            position: relative;
            width: 100%
        }

        .chosen-container-multi .chosen-choices li.search-choice {
            background: #f1f1f1;
            border: 1px solid #ededed;
            border-radius: 2px;
            box-shadow: none;
            color: #333;
            cursor: default;
            line-height: 13px;
            margin: 3px 0 3px 5px;
            padding: 3px 20px 3px 5px;
            position: relative
        }

        .pagination > .active > a, .pagination > .active > a:focus, .pagination > .active > a:hover, .pagination > .active > span, .pagination > .active > span:focus, .pagination > .active > span:hover {
            background-color: #f4f4f4;
            border-color: #DDD;
            color: inherit;
            cursor: default;
            z-index: 2
        }

        .pagination > li > a, .pagination > li > span {
            background-color: #FFF;
            border: 1px solid #DDD;
            color: inherit;
            float: left;
            line-height: 1.42857;
            margin-left: -1px;
            padding: 4px 10px;
            position: relative;
            text-decoration: none
        }

        .tooltip-inner {
            background-color: #2F4050
        }

        .tooltip.top .tooltip-arrow {
            border-top-color: #2F4050
        }

        .tooltip.right .tooltip-arrow {
            border-right-color: #2F4050
        }

        .tooltip.bottom .tooltip-arrow {
            border-bottom-color: #2F4050
        }

        .tooltip.left .tooltip-arrow {
            border-left-color: #2F4050
        }

        .easypiechart {
            position: relative;
            text-align: center
        }

        .easypiechart .h2 {
            margin-left: 10px;
            margin-top: 10px;
            display: inline-block
        }

        .easypiechart canvas {
            top: 0;
            left: 0
        }

        .easypiechart .easypie-text {
            line-height: 1;
            position: absolute;
            top: 33px;
            width: 100%;
            z-index: 1
        }

        .easypiechart img {
            margin-top: -4px
        }

        .jqstooltip {
            box-sizing: content-box
        }

        .fc-state-default {
            background-color: #fff;
            background-image: none;
            background-repeat: repeat-x;
            box-shadow: none;
            color: #333;
            text-shadow: none;
            border: 1px solid
        }

        .fc-button {
            color: inherit;
            border: 1px solid #e7eaec;
            cursor: pointer;
            display: inline-block;
            height: 1.9em;
            line-height: 1.9em;
            overflow: hidden;
            padding: 0 .6em;
            position: relative;
            white-space: nowrap
        }

        .fc-state-active {
            background-color: #1ab394;
            border-color: #1ab394;
            color: #fff
        }

        .fc-header-title h2 {
            font-size: 16px;
            font-weight: 600;
            color: inherit
        }

        .fc-content .fc-widget-content, .fc-content .fc-widget-header {
            border-color: #e7eaec;
            font-weight: 400
        }

        .fc-border-separate tbody {
            background-color: #F8F8F8
        }

        .fc-state-highlight {
            background: none repeat scroll 0 0 #FCF8E3
        }

        .external-event {
            padding: 5px 10px;
            border-radius: 2px;
            cursor: pointer;
            margin-bottom: 5px
        }

        .fc-ltr .fc-event-hori.fc-event-end, .fc-rtl .fc-event-hori.fc-event-start {
            border-radius: 2px
        }

        .fc-agenda .fc-event-time, .fc-event, .fc-event a {
            padding: 4px 6px;
            background-color: #1ab394;
            border-color: #1ab394
        }

        .fc-event-time, .fc-event-title {
            color: #717171;
            padding: 0 1px
        }

        .ui-calendar .fc-event-time, .ui-calendar .fc-event-title {
            color: #fff
        }

        .chat-activity-list .chat-element {
            border-bottom: 1px solid #e7eaec
        }

        .chat-element:first-child {
            margin-top: 0
        }

        .chat-element {
            padding-bottom: 15px
        }

        .chat-element, .chat-element .media {
            margin-top: 15px
        }

        .chat-element, .media-body {
            overflow: hidden
        }

        .media-body {
            display: block;
            width: auto
        }

        .chat-element > .pull-left {
            margin-right: 10px
        }

        .chat-element img.img-circle, .dropdown-messages-box img.img-circle {
            width: 38px;
            height: 38px
        }

        .chat-element .well {
            border: 1px solid #e7eaec;
            box-shadow: none;
            margin-top: 10px;
            margin-bottom: 5px;
            padding: 10px 20px;
            font-size: 11px;
            line-height: 16px
        }

        .chat-element .actions {
            margin-top: 10px
        }

        .chat-element .photos {
            margin: 10px 0
        }

        .right.chat-element > .pull-right {
            margin-left: 10px
        }

        .chat-photo {
            max-height: 180px;
            border-radius: 4px;
            overflow: hidden;
            margin-right: 10px;
            margin-bottom: 10px
        }

        .chat {
            margin: 0;
            padding: 0;
            list-style: none
        }

        .chat li {
            margin-bottom: 10px;
            padding-bottom: 5px;
            border-bottom: 1px dotted #B3A9A9
        }

        .chat li.left .chat-body {
            margin-left: 60px
        }

        .chat li.right .chat-body {
            margin-right: 60px
        }

        .chat li .chat-body p {
            margin: 0;
            color: #777
        }

        .chat .glyphicon, .panel .slidedown .glyphicon {
            margin-right: 5px
        }

        .chat-panel .panel-body {
            height: 350px;
            overflow-y: scroll
        }

        a.list-group-item.active, a.list-group-item.active:focus, a.list-group-item.active:hover {
            background-color: #1ab394;
            border-color: #1ab394;
            color: #FFF;
            z-index: 2
        }

        .list-group-item-heading {
            margin-top: 10px
        }

        .list-group-item-text {
            margin: 0 0 10px;
            color: inherit;
            font-size: 12px;
            line-height: inherit
        }

        .no-padding .list-group-item {
            border-left: none;
            border-right: none;
            border-bottom: none
        }

        .no-padding .list-group-item:first-child {
            border-left: none;
            border-right: none;
            border-bottom: none;
            border-top: none
        }

        .no-padding .list-group {
            margin-bottom: 0
        }

        .list-group-item {
            background-color: inherit;
            border: 1px solid #e7eaec;
            display: block;
            margin-bottom: -1px;
            padding: 10px 15px;
            position: relative
        }

        .elements-list .list-group-item {
            border-left: none;
            border-right: none;
            padding: 15px 25px
        }

        .elements-list .list-group-item:first-child {
            border-left: none;
            border-right: none;
            border-top: none !important
        }

        .elements-list .list-group {
            margin-bottom: 0
        }

        .elements-list a {
            color: inherit
        }

        .elements-list .list-group-item.active, .elements-list .list-group-item:hover {
            background: #f3f3f4;
            color: inherit;
            border-color: #e7eaec;
            border-radius: 0
        }

        .elements-list li.active {
            -webkit-transition: none;
            transition: none
        }

        .element-detail-box {
            padding: 25px
        }

        .flot-chart {
            display: block;
            height: 200px
        }

        .widget .flot-chart.dashboard-chart {
            display: block;
            height: 120px;
            margin-top: 40px
        }

        .flot-chart.dashboard-chart {
            display: block;
            height: 180px;
            margin-top: 40px
        }

        .flot-chart-content {
            width: 100%;
            height: 100%
        }

        .flot-chart-pie-content {
            width: 200px;
            height: 200px;
            margin: auto
        }

        .jqstooltip {
            position: absolute;
            display: block;
            left: 0;
            top: 0;
            visibility: hidden;
            background: #2b303a;
            background-color: rgba(43, 48, 58, .8);
            color: #fff;
            text-align: left;
            white-space: nowrap;
            z-index: 10000;
            padding: 5px;
            min-height: 22px;
            border-radius: 3px
        }

        .jqsfield {
            color: #fff;
            text-align: left
        }

        .h-200 {
            min-height: 200px
        }

        .legendLabel {
            padding-left: 5px
        }

        .stat-list li:first-child {
            margin-top: 0
        }

        .stat-list {
            list-style: none;
            padding: 0;
            margin: 0
        }

        .stat-percent {
            float: right
        }

        .stat-list li {
            margin-top: 15px;
            position: relative
        }

        table.dataTable thead .sorting, table.dataTable thead .sorting_asc:after, table.dataTable thead .sorting_asc_disabled, table.dataTable thead .sorting_desc, table.dataTable thead .sorting_desc_disabled {
            background: 0 0
        }

        table.dataTable thead .sorting_asc:after {
            float: right;
            font-family: fontawesome
        }

        table.dataTable thead .sorting_desc:after {
            content: "\f0dd";
            float: right;
            font-family: fontawesome
        }

        table.dataTable thead .sorting:after {
            content: "\f0dc";
            float: right;
            font-family: fontawesome;
            color: rgba(50, 50, 50, .5)
        }

        .dataTables_wrapper {
            padding-bottom: 30px
        }

        .img-circle {
            border-radius: 50%
        }

        .btn-circle {
            width: 30px;
            height: 30px;
            padding: 6px 0;
            border-radius: 15px;
            text-align: center;
            font-size: 12px;
            line-height: 1.428571429
        }

        .btn-circle.btn-lg {
            width: 50px;
            height: 50px;
            padding: 10px 16px;
            border-radius: 25px;
            font-size: 18px;
            line-height: 1.33
        }

        .btn-circle.btn-xl {
            width: 70px;
            height: 70px;
            padding: 10px 16px;
            border-radius: 35px;
            font-size: 24px;
            line-height: 1.33
        }

        .show-grid [class^=col-] {
            padding-top: 10px;
            padding-bottom: 10px;
            border: 1px solid #ddd;
            background-color: #eee !important
        }

        .show-grid {
            margin: 15px 0
        }

        .css-animation-box h1 {
            font-size: 44px
        }

        .animation-efect-links a {
            padding: 4px 6px;
            font-size: 12px
        }

        #animation_box {
            background-color: #f9f8f8;
            border-radius: 16px;
            width: 80%;
            margin: 0 auto;
            padding-top: 80px
        }

        .animation-text-box {
            position: absolute;
            margin-top: 40px;
            left: 50%;
            margin-left: -100px;
            width: 200px
        }

        .animation-text-info {
            position: absolute;
            margin-top: -60px;
            left: 50%;
            margin-left: -100px;
            width: 200px;
            font-size: 10px
        }

        .animation-text-box h2 {
            font-size: 54px;
            font-weight: 600;
            margin-bottom: 5px
        }

        .animation-text-box p {
            font-size: 12px;
            text-transform: uppercase
        }

        .pace {
            -webkit-pointer-events: none;
            pointer-events: none;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none
        }

        .pace .pace-progress {
            background: #1ab394;
            position: fixed;
            z-index: 2000;
            top: 0;
            width: 100%;
            height: 2px
        }

        .pace-inactive {
            display: none
        }

        .widget {
            border-radius: 5px;
            padding: 15px 20px;
            margin-bottom: 10px;
            margin-top: 10px
        }

        .widget.style1 h2 {
            font-size: 30px
        }

        .widget h2, .widget h3 {
            margin-top: 5px;
            margin-bottom: 0
        }

        .widget-text-box {
            padding: 20px;
            border: 1px solid #e7eaec;
            background: #fff
        }

        .widget-head-color-box {
            border-radius: 5px 5px 0 0;
            margin-top: 10px
        }

        .widget .flot-chart {
            height: 100px
        }

        .vertical-align div {
            display: inline-block;
            vertical-align: middle
        }

        .vertical-align h2, .vertical-align h3 {
            margin: 0
        }

        .todo-list {
            list-style: none outside none;
            margin: 0;
            padding: 0;
            font-size: 14px
        }

        .todo-list.small-list {
            font-size: 12px
        }

        .todo-list.small-list > li {
            background: #f3f3f4;
            border-left: none;
            border-right: none;
            border-radius: 4px;
            color: inherit;
            margin-bottom: 2px;
            padding: 6px 6px 6px 12px
        }

        .todo-list.small-list .btn-group-xs > .btn, .todo-list.small-list .btn-xs {
            border-radius: 5px;
            font-size: 10px;
            line-height: 1.5;
            padding: 1px 2px 1px 5px
        }

        .todo-list > li {
            background: #f3f3f4;
            border-left: 6px solid #e7eaec;
            border-right: 6px solid #e7eaec;
            border-radius: 4px;
            color: inherit;
            margin-bottom: 2px;
            padding: 10px
        }

        .todo-list .handle {
            cursor: move;
            display: inline-block;
            font-size: 16px;
            margin: 0 5px
        }

        .todo-list > li .label {
            font-size: 9px;
            margin-left: 10px
        }

        .check-link {
            font-size: 16px
        }

        .todo-completed {
            text-decoration: line-through
        }

        .geo-statistic h1 {
            font-size: 36px;
            margin-bottom: 0
        }

        .glyphicon.fa {
            font-family: FontAwesome
        }

        .inline {
            display: inline-block !important
        }

        .input-s-sm {
            width: 120px
        }

        .input-s {
            width: 200px
        }

        .input-s-lg {
            width: 250px
        }

        .i-checks {
            padding-left: 0
        }

        .form-control, .single-line {
            background-color: #FFF;
            background-image: none;
            border: 1px solid #e5e6e7;
            border-radius: 1px;
            color: inherit;
            display: block;
            padding: 6px 12px;
            -webkit-transition: border-color .15s ease-in-out 0s, box-shadow .15s ease-in-out 0s;
            transition: border-color .15s ease-in-out 0s, box-shadow .15s ease-in-out 0s;
            width: 100%;
            font-size: 14px
        }

        .form-control:focus, .single-line:focus {
            border-color: #1ab394 !important
        }

        .has-success .form-control {
            border-color: #1ab394
        }

        .has-warning .form-control {
            border-color: #f8ac59
        }

        .has-error .form-control {
            border-color: #ed5565
        }

        .has-success .control-label {
            color: #1ab394
        }

        .has-warning .control-label {
            color: #f8ac59
        }

        .has-error .control-label {
            color: #ed5565
        }

        .input-group-addon {
            background-color: #fff;
            border: 1px solid #E5E6E7;
            border-radius: 1px;
            color: inherit;
            font-size: 14px;
            font-weight: 400;
            line-height: 1;
            padding: 6px 12px;
            text-align: center
        }

        .spinner-buttons.input-group-btn .btn-xs {
            line-height: 1.13
        }

        .spinner-buttons.input-group-btn {
            width: 20%
        }

        .noUi-connect {
            background: none repeat scroll 0 0 #1ab394;
            box-shadow: none
        }

        .slider_red .noUi-connect {
            background: none repeat scroll 0 0 #ed5565;
            box-shadow: none
        }

        .ui-sortable .ibox-title {
            cursor: move
        }

        .ui-sortable-placeholder {
            border: 1px dashed #cecece !important;
            visibility: visible !important;
            background: #e7eaec
        }

        .ibox.ui-sortable-placeholder {
            margin: 0 0 23px !important
        }

        .tabs-container .panel-body {
            background: #fff;
            border: 1px solid #e7eaec;
            border-radius: 2px;
            padding: 20px;
            position: relative
        }

        .tabs-container .nav-tabs > li.active > a, .tabs-container .nav-tabs > li.active > a:focus, .tabs-container .nav-tabs > li.active > a:hover {
            background-color: #fff
        }

        .tabs-container .nav-tabs > li {
            float: left;
            margin-bottom: -1px
        }

        .tabs-container .nav-tabs > li.active > a, .tabs-container .nav-tabs > li.active > a:focus, .tabs-container .nav-tabs > li.active > a:hover {
            border: 1px solid #e7eaec;
            border-bottom-color: transparent
        }

        .tabs-container .nav-tabs {
            border-bottom: 1px solid #e7eaec
        }

        .tabs-container .tab-pane .panel-body {
            border-top: none
        }

        .tabs-container .tabs-left .tab-pane .panel-body, .tabs-container .tabs-right .tab-pane .panel-body {
            border-top: 1px solid #e7eaec
        }

        .tabs-container .nav-tabs > li a:hover {
            background: 0 0;
            border-color: transparent
        }

        .tabs-container .tabs-below > .nav-tabs, .tabs-container .tabs-left > .nav-tabs, .tabs-container .tabs-right > .nav-tabs {
            border-bottom: 0
        }

        .tabs-container .tabs-left .panel-body {
            position: static
        }

        .tabs-container .tabs-left > .nav-tabs, .tabs-container .tabs-right > .nav-tabs {
            width: 20%
        }

        .tabs-container .tabs-left .panel-body {
            width: 80%;
            margin-left: 20%
        }

        .tabs-container .tabs-right .panel-body {
            width: 80%;
            margin-right: 20%
        }

        .tabs-container .pill-content > .pill-pane, .tabs-container .tab-content > .tab-pane {
            display: none
        }

        .tabs-container .pill-content > .active, .tabs-container .tab-content > .active {
            display: block
        }

        .tabs-container .tabs-below > .nav-tabs {
            border-top: 1px solid #e7eaec
        }

        .tabs-container .tabs-below > .nav-tabs > li {
            margin-top: -1px;
            margin-bottom: 0
        }

        .tabs-container .tabs-below > .nav-tabs > li > a {
            border-radius: 0 0 4px 4px
        }

        .tabs-container .tabs-below > .nav-tabs > li > a:focus, .tabs-container .tabs-below > .nav-tabs > li > a:hover {
            border-top-color: #e7eaec;
            border-bottom-color: transparent
        }

        .tabs-container .tabs-left > .nav-tabs > li, .tabs-container .tabs-right > .nav-tabs > li {
            float: none
        }

        .tabs-container .tabs-left > .nav-tabs > li > a, .tabs-container .tabs-right > .nav-tabs > li > a {
            min-width: 74px;
            margin-right: 0;
            margin-bottom: 3px
        }

        .tabs-container .tabs-left > .nav-tabs {
            float: left;
            margin-right: 19px
        }

        .tabs-container .tabs-left > .nav-tabs > li > a {
            margin-right: -1px;
            border-radius: 4px 0 0 4px
        }

        .tabs-container .tabs-left > .nav-tabs .active > a, .tabs-container .tabs-left > .nav-tabs .active > a:focus, .tabs-container .tabs-left > .nav-tabs .active > a:hover {
            border-color: #e7eaec transparent #e7eaec #e7eaec;
            *border-right-color: #fff
        }

        .tabs-container .tabs-right > .nav-tabs {
            float: right;
            margin-left: 19px
        }

        .tabs-container .tabs-right > .nav-tabs > li > a {
            margin-left: -1px;
            border-radius: 0 4px 4px 0
        }

        .tabs-container .tabs-right > .nav-tabs .active > a, .tabs-container .tabs-right > .nav-tabs .active > a:focus, .tabs-container .tabs-right > .nav-tabs .active > a:hover {
            border-color: #e7eaec #e7eaec #e7eaec transparent;
            *border-left-color: #fff;
            z-index: 1
        }

        .onoffswitch {
            position: relative;
            width: 54px;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none
        }

        .onoffswitch-checkbox {
            display: none
        }

        .onoffswitch-label {
            display: block;
            overflow: hidden;
            cursor: pointer;
            border: 2px solid #1AB394;
            border-radius: 3px
        }

        .onoffswitch-inner {
            display: block;
            width: 200%;
            margin-left: -100%;
            -webkit-transition: margin .3s ease-in 0s;
            transition: margin .3s ease-in 0s
        }

        .onoffswitch-inner:after, .onoffswitch-inner:before {
            display: block;
            float: left;
            width: 50%;
            height: 16px;
            padding: 0;
            line-height: 16px;
            font-size: 10px;
            font-family: Trebuchet, Arial, sans-serif;
            font-weight: 700;
            box-sizing: border-box
        }

        .onoffswitch-inner:before {
            content: "ON";
            padding-left: 7px;
            background-color: #1AB394;
            color: #FFF
        }

        .onoffswitch-inner:after {
            content: "OFF";
            padding-right: 7px;
            background-color: #FFF;
            color: #919191;
            text-align: right
        }

        .onoffswitch-switch {
            display: block;
            width: 18px;
            margin: 0;
            background: #FFF;
            border: 2px solid #1AB394;
            border-radius: 3px;
            position: absolute;
            top: 0;
            bottom: 0;
            right: 36px;
            -webkit-transition: all .3s ease-in 0s;
            transition: all .3s ease-in 0s
        }

        .onoffswitch-checkbox:checked + .onoffswitch-label .onoffswitch-inner {
            margin-left: 0
        }

        .onoffswitch-checkbox:checked + .onoffswitch-label .onoffswitch-switch {
            right: 0
        }

        .dd {
            position: relative;
            display: block;
            margin: 0;
            padding: 0;
            list-style: none;
            font-size: 13px;
            line-height: 20px
        }

        .dd-list {
            display: block;
            position: relative;
            margin: 0;
            padding: 0;
            list-style: none
        }

        .dd-list .dd-list {
            padding-left: 30px
        }

        .dd-collapsed .dd-list {
            display: none
        }

        .dd-empty, .dd-item, .dd-placeholder {
            display: block;
            position: relative;
            margin: 0;
            padding: 0;
            min-height: 20px;
            font-size: 13px;
            line-height: 20px
        }

        .dd-handle {
            display: block;
            margin: 5px 0;
            padding: 5px 10px;
            color: #333;
            text-decoration: none;
            border: 1px solid #e7eaec;
            background: #f5f5f5;
            border-radius: 3px;
            box-sizing: border-box;
            -moz-box-sizing: border-box
        }

        .dd-handle span {
            font-weight: 700
        }

        .dd-handle:hover {
            background: #f0f0f0;
            cursor: pointer;
            font-weight: 700
        }

        .dd-item > button {
            display: block;
            position: relative;
            cursor: pointer;
            float: left;
            width: 25px;
            height: 20px;
            margin: 5px 0;
            padding: 0;
            text-indent: 100%;
            white-space: nowrap;
            overflow: hidden;
            border: 0;
            background: 0 0;
            font-size: 12px;
            line-height: 1;
            text-align: center;
            font-weight: 700
        }

        .dd-item > button:before {
            content: '+';
            display: block;
            position: absolute;
            width: 100%;
            text-align: center;
            text-indent: 0
        }

        .dd-item > button[data-action=collapse]:before {
            content: '-'
        }

        #nestable2 .dd-item > button {
            font-family: FontAwesome;
            height: 34px;
            width: 33px;
            color: #c1c1c1
        }

        #nestable2 .dd-item > button:before {
            content: "\f067"
        }

        #nestable2 .dd-item > button[data-action=collapse]:before {
            content: "\f068"
        }

        .dd-empty, .dd-placeholder {
            margin: 5px 0;
            padding: 0;
            min-height: 30px;
            background: #f2fbff;
            border: 1px dashed #b6bcbf;
            box-sizing: border-box;
            -moz-box-sizing: border-box
        }

        .dd-empty {
            border: 1px dashed #bbb;
            min-height: 100px;
            background-color: #e5e5e5;
            background-image: -webkit-linear-gradient(45deg, #fff 25%, transparent 25%, transparent 75%, #fff 75%, #fff), -webkit-linear-gradient(45deg, #fff 25%, transparent 25%, transparent 75%, #fff 75%, #fff);
            background-image: linear-gradient(45deg, #fff 25%, transparent 25%, transparent 75%, #fff 75%, #fff), linear-gradient(45deg, #fff 25%, transparent 25%, transparent 75%, #fff 75%, #fff);
            background-size: 60px 60px;
            background-position: 0 0, 30px 30px
        }

        .dd-dragel {
            position: absolute;
            z-index: 9999;
            pointer-events: none
        }

        .dd-dragel > .dd-item .dd-handle {
            margin-top: 0
        }

        .dd-dragel .dd-handle {
            box-shadow: 2px 4px 6px 0 rgba(0, 0, 0, .1)
        }

        .nestable-lists {
            display: block;
            clear: both;
            padding: 30px 0;
            width: 100%;
            border: 0;
            border-top: 2px solid #ddd;
            border-bottom: 2px solid #ddd
        }

        #nestable-menu {
            padding: 0;
            margin: 10px 0 20px
        }

        #nestable-output, #nestable2-output {
            width: 100%;
            line-height: 1.333333em;
            font-family: lucida grande, lucida sans unicode, helvetica, arial, sans-serif
        }

        #nestable2 .dd-handle {
            color: inherit;
            border: 1px dashed #e7eaec;
            background: #f3f3f4;
            padding: 10px
        }

        #nestable2 span.label {
            margin-right: 10px
        }

        #nestable-output, #nestable2-output {
            font-size: 12px;
            padding: 25px;
            box-sizing: border-box;
            -moz-box-sizing: border-box
        }

        .CodeMirror {
            border: 1px solid #eee;
            height: auto
        }

        .CodeMirror-scroll {
            overflow-y: hidden;
            overflow-x: auto
        }

        .google-map {
            height: 300px
        }

        label.error {
            color: #cc5965;
            display: inline-block;
            margin-left: 5px
        }

        .form-control.error {
            border: 1px dotted #cc5965
        }

        .gridStyle {
            border: 1px solid #d4d4d4;
            width: 100%;
            height: 400px
        }

        .gridStyle2 {
            border: 1px solid #d4d4d4;
            width: 500px;
            height: 300px
        }

        .ngH eaderCell {
            border-right: none;
            border-bottom: 1px solid #e7eaec
        }

        .ngCell {
            border-right: none
        }

        .ngTopPanel {
            background: #F5F5F6
        }

        .ngRow.even {
            background: #f9f9f9
        }

        .ngRow.selected {
            background: #EBF2F1
        }

        .ngRow {
            border-bottom: 1px solid #e7eaec
        }

        .ngCell {
            background-color: transparent
        }

        .ngHeaderCell {
            border-right: none
        }

        #toast-container > .toast {
            background-image: none !important
        }

        #toast-container > .toast:before {
            position: fixed;
            font-family: FontAwesome;
            font-size: 24px;
            line-height: 24px;
            float: left;
            color: #FFF;
            padding-right: .5em;
            margin: auto .5em auto -1.5em
        }

        #toast-container > div {
            box-shadow: 0 0 3px #999;
            opacity: .9;
            -ms-filter: alpha(opacity=90);
            filter: alpha(opacity=90)
        }

        #toast-container > :hover {
            box-shadow: 0 0 4px #999;
            opacity: 1;
            -ms-filter: alpha(opacity=100);
            filter: alpha(opacity=100);
            cursor: pointer
        }

        .toast, .toast-success {
            background-color: #1ab394
        }

        .toast-error {
            background-color: #ed5565
        }

        .toast-info {
            background-color: #23c6c8
        }

        .toast-warning {
            background-color: #f8ac59
        }

        .toast-top-full-width {
            margin-top: 20px
        }

        .toast-bottom-full-width {
            margin-bottom: 20px
        }

        .img-container, .img-preview {
            overflow: hidden;
            text-align: center;
            width: 100%
        }

        .img-preview-sm {
            height: 130px;
            width: 200px
        }

        .forum-post-container .media {
            margin: 10px;
            padding: 20px 10px;
            border-bottom: 1px solid #f1f1f1
        }

        .forum-avatar {
            float: left;
            margin-right: 20px;
            text-align: center;
            width: 110px
        }

        .forum-avatar .img-circle {
            height: 48px;
            width: 48px
        }

        .author-info {
            color: #676a6c;
            font-size: 11px;
            margin-top: 5px;
            text-align: center
        }

        .forum-post-info {
            padding: 9px 12px 6px;
            background: #f9f9f9;
            border: 1px solid #f1f1f1
        }

        .media-body > .media {
            background: #f9f9f9;
            border-radius: 3px;
            border: 1px solid #f1f1f1
        }

        .forum-post-container .media-body .photos {
            margin: 10px 0
        }

        .forum-photo {
            max-width: 140px;
            border-radius: 3px
        }

        .media-body > .media .forum-avatar {
            width: 70px;
            margin-right: 10px
        }

        .media-body > .media .forum-avatar .img-circle {
            height: 38px;
            width: 38px
        }

        .mid-icon {
            font-size: 66px
        }

        .forum-item {
            margin: 10px 0;
            padding: 10px 0 20px;
            border-bottom: 1px solid #f1f1f1
        }

        .views-number {
            font-size: 24px;
            line-height: 18px;
            font-weight: 400
        }

        .forum-container, .forum-post-container {
            padding: 30px !important
        }

        .forum-item small {
            color: #999
        }

        .forum-item .forum-sub-title {
            color: #999;
            margin-left: 50px
        }

        .forum-title {
            margin: 15px 0
        }

        .forum-info {
            text-align: center
        }

        .forum-desc {
            color: #999
        }

        .forum-icon {
            float: left;
            width: 30px;
            margin-right: 20px;
            text-align: center
        }

        a.forum-item-title {
            color: inherit;
            display: block;
            font-size: 18px;
            font-weight: 600
        }

        a.forum-item-title:hover {
            color: inherit
        }

        .forum-icon .fa {
            font-size: 30px;
            margin-top: 8px;
            color: #9b9b9b
        }

        .forum-item.active .fa, .forum-item.active a.forum-item-title {
            color: #1ab394
        }

        @media (max-width: 992px) {
            .forum-info {
                margin: 15px 0 10px;
                display: none
            }

            .forum-desc {
                float: none !important
            }
        }

        .vertical-container {
            width: 90%;
            max-width: 1170px;
            margin: 0 auto
        }

        .vertical-container::after {
            content: '';
            display: table;
            clear: both
        }

        #vertical-timeline {
            position: relative;
            padding: 0;
            margin-top: 2em;
            margin-bottom: 2em
        }

        #vertical-timeline::before {
            content: '';
            position: absolute;
            top: 0;
            left: 18px;
            height: 100%;
            width: 4px;
            background: #f1f1f1
        }

        .vertical-timeline-content .btn {
            float: right
        }

        #vertical-timeline.light-timeline:before {
            background: #e7eaec
        }

        .dark-timeline .vertical-timeline-content:before {
            border-color: transparent #f5f5f5 transparent transparent
        }

        .dark-timeline.center-orientation .vertical-timeline-content:before {
            border-color: transparent transparent transparent #f5f5f5
        }

        .dark-timeline .vertical-timeline-block:nth-child(2n) .vertical-timeline-content:before, .dark-timeline.center-orientation .vertical-timeline-block:nth-child(2n) .vertical-timeline-content:before {
            border-color: transparent #f5f5f5 transparent transparent
        }

        .dark-timeline .vertical-timeline-content, .dark-timeline.center-orientation .vertical-timeline-content {
            background: #f5f5f5
        }

        @media only screen and (min-width: 1170px) {
            #vertical-timeline.center-orientation {
                margin-top: 3em;
                margin-bottom: 3em
            }

            #vertical-timeline.center-orientation:before {
                left: 50%;
                margin-left: -2px
            }
        }

        @media only screen and (max-width: 1170px) {
            .center-orientation.dark-timeline .vertical-timeline-content:before {
                border-color: transparent #f5f5f5 transparent transparent
            }
        }

        .vertical-timeline-block {
            position: relative;
            margin: 2em 0
        }

        .vertical-timeline-block:after {
            content: "";
            display: table;
            clear: both
        }

        .vertical-timeline-block:first-child {
            margin-top: 0
        }

        .vertical-timeline-block:last-child {
            margin-bottom: 0
        }

        @media only screen and (min-width: 1170px) {
            .center-orientation .vertical-timeline-block {
                margin: 4em 0
            }

            .center-orientation .vertical-timeline-block:first-child {
                margin-top: 0
            }

            .center-orientation .vertical-timeline-block:last-child {
                margin-bottom: 0
            }
        }

        .vertical-timeline-icon {
            position: absolute;
            top: 0;
            left: 0;
            width: 40px;
            height: 40px;
            border-radius: 50%;
            font-size: 16px;
            border: 3px solid #f1f1f1;
            text-align: center
        }

        .vertical-timeline-icon i {
            display: block;
            width: 24px;
            height: 24px;
            position: relative;
            left: 50%;
            top: 50%;
            margin-left: -12px;
            margin-top: -9px
        }

        @media only screen and (min-width: 1170px) {
            .center-orientation .vertical-timeline-icon {
                width: 50px;
                height: 50px;
                left: 50%;
                margin-left: -25px;
                -webkit-transform: translateZ(0);
                -webkit-backface-visibility: hidden;
                font-size: 19px
            }

            .center-orientation .vertical-timeline-icon i {
                margin-left: -12px;
                margin-top: -10px
            }

            .center-orientation .cssanimations .vertical-timeline-icon.is-hidden {
                visibility: hidden
            }
        }

        .vertical-timeline-content {
            position: relative;
            margin-left: 60px;
            background: #fff;
            border-radius: .25em;
            padding: 1em
        }

        .vertical-timeline-content:after {
            content: "";
            display: table;
            clear: both
        }

        .vertical-timeline-content h2 {
            font-weight: 400;
            margin-top: 4px
        }

        .vertical-timeline-content p {
            margin: 1em 0;
            line-height: 1.6
        }

        .vertical-timeline-content .vertical-date {
            float: left;
            font-weight: 500
        }

        .vertical-date small {
            color: #1ab394;
            font-weight: 400
        }

        .vertical-timeline-content::before {
            content: '';
            position: absolute;
            top: 16px;
            right: 100%;
            height: 0;
            width: 0;
            border: 7px solid transparent;
            border-right: 7px solid #fff
        }

        @media only screen and (min-width: 768px) {
            .vertical-timeline-content h2 {
                font-size: 18px
            }

            .vertical-timeline-content p {
                font-size: 13px
            }
        }

        @media only screen and (min-width: 1170px) {
            .center-orientation .vertical-timeline-content {
                margin-left: 0;
                padding: 1.6em;
                width: 45%
            }

            .center-orientation .vertical-timeline-content::before {
                top: 24px;
                left: 100%;
                border-color: transparent;
                border-left-color: #fff
            }

            .center-orientation .vertical-timeline-content .btn {
                float: left
            }

            .center-orientation .vertical-timeline-content .vertical-date {
                position: absolute;
                width: 100%;
                left: 122%;
                top: 2px;
                font-size: 14px
            }

            .center-orientation .vertical-timeline-block:nth-child(even) .vertical-timeline-content {
                float: right
            }

            .center-orientation .vertical-timeline-block:nth-child(even) .vertical-timeline-content::before {
                top: 24px;
                left: auto;
                right: 100%;
                border-color: transparent;
                border-right-color: #fff
            }

            .center-orientation .vertical-timeline-block:nth-child(even) .vertical-timeline-content .btn {
                float: right
            }

            .center-orientation .vertical-timeline-block:nth-child(even) .vertical-timeline-content .vertical-date {
                left: auto;
                right: 122%;
                text-align: right
            }

            .center-orientation .cssanimations .vertical-timeline-content.is-hidden {
                visibility: hidden
            }
        }

        .sidebard-panel {
            width: 220px;
            background: #ebebed;
            padding: 10px 20px;
            position: absolute;
            right: 0
        }

        .sidebard-panel .feed-element img.img-circle {
            width: 32px;
            height: 32px
        }

        .media-body, .sidebard-panel .feed-element, .sidebard-panel p {
            font-size: 12px
        }

        .sidebard-panel .feed-element {
            margin-top: 20px;
            padding-bottom: 0
        }

        .sidebard-panel .list-group {
            margin-bottom: 10px
        }

        .sidebard-panel .list-group .list-group-item {
            padding: 5px 0;
            font-size: 12px;
            border: 0
        }

        .sidebar-content .wrapper, .wrapper.sidebar-content {
            padding-right: 240px !important
        }

        #right-sidebar {
            background-color: #fff;
            border-left: 1px solid #e7eaec;
            border-top: 1px solid #e7eaec;
            overflow: hidden;
            position: fixed;
            top: 60px;
            width: 260px !important;
            z-index: 1009;
            bottom: 0;
            right: -260px
        }

        #right-sidebar.sidebar-open {
            right: 0
        }

        #right-sidebar.sidebar-open.sidebar-top {
            top: 0;
            border-top: none
        }

        .sidebar-container ul.nav-tabs {
            border: none
        }

        .sidebar-container ul.nav-tabs.navs-4 li {
            width: 25%
        }

        .sidebar-container ul.nav-tabs.navs-3 li {
            width: 33.3333%
        }

        .sidebar-container ul.nav-tabs.navs-2 li {
            width: 50%
        }

        .sidebar-container ul.nav-tabs li {
            border: none
        }

        .sidebar-container ul.nav-tabs li a {
            border: none;
            padding: 12px 10px;
            margin: 0;
            border-radius: 0;
            background: #2f4050;
            color: #fff;
            text-align: center;
            border-right: 1px solid #334556
        }

        .sidebar-container ul.nav-tabs li.active a {
            border: none;
            background: #f9f9f9;
            color: #676a6c;
            font-weight: 700
        }

        .sidebar-container .nav-tabs > li.active > a:focus, .sidebar-container .nav-tabs > li.active > a:hover {
            border: none
        }

        .sidebar-container ul.sidebar-list {
            margin: 0;
            padding: 0
        }

        .sidebar-container ul.sidebar-list li {
            border-bottom: 1px solid #e7eaec;
            padding: 15px 20px;
            list-style: none;
            font-size: 12px
        }

        .sidebar-container .sidebar-message:nth-child(2n+2) {
            background: #f9f9f9
        }

        .sidebar-container ul.sidebar-list li a {
            text-decoration: none;
            color: inherit
        }

        .sidebar-container .sidebar-content {
            padding: 15px 20px;
            font-size: 12px
        }

        .sidebar-container .sidebar-title {
            background: #f9f9f9;
            padding: 20px;
            border-bottom: 1px solid #e7eaec
        }

        .sidebar-container .sidebar-title h3 {
            margin-bottom: 3px;
            padding-left: 2px
        }

        .sidebar-container .tab-content h4 {
            margin-bottom: 5px
        }

        .sidebar-container .sidebar-message > a > .pull-left {
            margin-right: 10px
        }

        .sidebar-container .sidebar-message > a {
            text-decoration: none;
            color: inherit
        }

        .sidebar-container .sidebar-message {
            padding: 15px 20px
        }

        .sidebar-container .sidebar-message .message-avatar {
            height: 38px;
            width: 38px;
            border-radius: 50%
        }

        .sidebar-container .setings-item {
            padding: 15px 20px;
            border-bottom: 1px solid #e7eaec
        }

        body {
            font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
            font-size: 13px;
            color: #676a6c;
            overflow-x: hidden
        }

        body, body.full-height-layout #page-wrapper, body.full-height-layout #wrapper, html {
            height: 100%;
        }

        #page-wrapper {
            min-height: auto
        }

        body.boxed-layout {
            background: url(patterns/shattered.png)
        }

        body.boxed-layout #wrapper {
            background-color: #2f4050;
            max-width: 1200px;
            margin: 0 auto
        }

        .boxed-layout #wrapper.top-navigation, .top-navigation.boxed-layout #wrapper {
            max-width: 1300px !important
        }

        .block {
            display: block
        }

        .clear {
            display: block;
            overflow: hidden
        }

        a {
            cursor: pointer
        }

        a:focus, a:hover {
            text-decoration: none
        }

        .border-bottom {
            border-bottom: 1px solid #e7eaec !important
        }

        .font-bold {
            font-weight: 600
        }

        .font-noraml {
            font-weight: 400
        }

        .text-uppercase {
            text-transform: uppercase
        }

        .b-r {
            border-right: 1px solid #e7eaec
        }

        .hr-line-dashed {
            border-top: 1px dashed #e7eaec;
            color: #fff;
            background-color: #fff;
            height: 1px;
            margin: 20px 0
        }

        .hr-line-solid {
            border-bottom: 1px solid #e7eaec;
            background-color: rgba(0, 0, 0, 0);
            border-style: solid !important;
            margin-top: 15px;
            margin-bottom: 15px
        }

        video {
            width: 100% !important;
            height: auto !important
        }

        .gallery > .row > div {
            margin-bottom: 15px
        }

        .fancybox img {
            margin-bottom: 5px;
            width: 24%
        }

        .note-editor {
            height: auto !important;
            min-height: 100px;
            border: solid 1px #e5e6e7
        }

        .modal-content {
            background-clip: padding-box;
            background-color: #FFF;
            border: 1px solid rgba(0, 0, 0, 0);
            border-radius: 4px;
            box-shadow: 0 1px 3px rgba(0, 0, 0, .3);
            outline: 0 none
        }

        .modal-dialog {
            z-index: 1200
        }

        .modal-body {
            padding: 20px 30px 30px
        }

        .inmodal .modal-body {
            background: #f8fafb
        }

        .inmodal .modal-header {
            padding: 30px 15px;
            text-align: center
        }

        .animated.modal.fade .modal-dialog {
            -webkit-transform: none;
            -ms-transform: none;
            transform: none
        }

        .inmodal .modal-title {
            font-size: 26px
        }

        .inmodal .modal-icon {
            font-size: 84px;
            color: #e2e3e3
        }

        .modal-footer {
            margin-top: 0
        }

        #wrapper {
            width: 100%;
            overflow-x: hidden;
            background-color: #2f4050
        }

        .wrapper {
            padding: 0 20px
        }

        .wrapper-content {
            padding: 20px
        }

        #page-wrapper {
            padding: 0 15px;
            position: inherit;
            margin: 0 0 0 220px
        }

        .title-action {
            text-align: right;
            padding-top: 30px
        }

        .ibox-content h1, .ibox-content h2, .ibox-content h3, .ibox-content h4, .ibox-content h5, .ibox-title h1, .ibox-title h2, .ibox-title h3, .ibox-title h4, .ibox-title h5 {
            margin-top: 5px
        }

        ol.unstyled, ul.unstyled {
            list-style: none outside none;
            margin-left: 0
        }

        .big-icon {
            font-size: 160px;
            color: #e5e6e7
        }

        .footer {
            background: none repeat scroll 0 0 #fff;
            border-top: 1px solid #e7eaec;
            overflow: hidden;
            padding: 10px 20px;
            margin: 0 -15px;
            height: 36px
        }

        .footer.fixed_full {
            position: fixed;
            bottom: 0;
            left: 0;
            right: 0;
            z-index: 1000;
            padding: 10px 20px;
            background: #fff;
            border-top: 1px solid #e7eaec
        }

        .footer.fixed {
            position: fixed;
            bottom: 0;
            left: 0;
            right: 0;
            z-index: 1000;
            padding: 10px 20px;
            background: #fff;
            border-top: 1px solid #e7eaec;
            margin-left: 220px
        }

        body.body-small.mini-navbar .footer.fixed, body.mini-navbar .footer.fixed {
            margin: 0 0 0 70px
        }

        body.canvas-menu .footer.fixed, body.mini-navbar.canvas-menu .footer.fixed {
            margin: 0 !important
        }

        body.fixed-sidebar.body-small.mini-navbar .footer.fixed {
            margin: 0 0 0 220px
        }

        body.body-small .footer.fixed {
            margin-left: 0
        }

        .page-heading {
            border-top: 0;
            padding: 0 20px 20px
        }

        .panel-heading h1, .panel-heading h2 {
            margin-bottom: 5px
        }

        .content-tabs {
            position: relative;
            height: 42px;
            background: #fafafa;
            line-height: 40px
        }

        .content-tabs .roll-nav, .page-tabs-list {
            position: absolute;
            width: 40px;
            height: 40px;
            text-align: center;
            color: #999;
            z-index: 2;
            top: 0
        }

        .content-tabs .roll-left {
            left: 0;
            border-right: solid 1px #eee
        }

        .content-tabs .roll-right {
            right: 0;
            border-left: solid 1px #eee
        }

        .content-tabs button {
            background: #fff;
            border: 0;
            height: 40px;
            width: 40px;
            outline: 0
        }

        .content-tabs button:hover {
            background: #fafafa
        }

        nav.page-tabs {
            margin-left: 40px;
            width: 100000px;
            height: 40px;
            overflow: hidden
        }

        nav.page-tabs .page-tabs-content {
            float: left
        }

        .page-tabs a {
            display: block;
            float: left;
            border-right: solid 1px #eee;
            padding: 0 15px
        }

        .page-tabs a i:hover {
            color: #c00
        }

        .content-tabs .roll-nav:hover, .page-tabs a:hover {
            color: #777;
            background: #f2f2f2;
            cursor: pointer
        }

        .roll-right.J_tabRight {
            right: 140px
        }

        .roll-right.btn-group {
            right: 60px;
            width: 80px;
            padding: 0
        }

        .roll-right.btn-group button {
            width: 80px
        }

        .roll-right.J_tabExit {
            background: #fff;
            height: 40px;
            width: 60px;
            outline: 0
        }

        .dropdown-menu-right {
            left: auto
        }

        #content-main {
            height: calc(100% - 140px);
            overflow: hidden
        }

        .fixed-nav #content-main {
            height: calc(100% - 80px);
            overflow: hidden
        }

        .table-bordered {
            border: 1px solid #EBEBEB
        }

        .table-bordered > thead > tr > td, .table-bordered > thead > tr > th {
            background-color: #F5F5F6
        }

        .table-bordered > tbody > tr > td, .table-bordered > tbody > tr > th, .table-bordered > tfoot > tr > td, .table-bordered > tfoot > tr > th, .table-bordered > thead > tr > td, .table-bordered > thead > tr > th {
            border: 1px solid #e7e7e7
        }

        .table > thead > tr > th {
            border-bottom: 1px solid #DDD
        }

        .table > tbody > tr > td, .table > tbody > tr > th, .table > tfoot > tr > td, .table > tfoot > tr > th, .table > thead > tr > td, .table > thead > tr > th {
            border-top: 1px solid #e7eaec;
            line-height: 1.42857;
            padding: 8px;
            vertical-align: middle
        }

        .panel.blank-panel {
            background: 0 0;
            margin: 0
        }

        .blank-panel .panel-heading {
            padding-bottom: 0
        }

        .nav-tabs > li.active > a, .nav-tabs > li.active > a:focus, .nav-tabs > li.active > a:hover {
            -moz-border-bottom-colors: none;
            -moz-border-left-colors: none;
            -moz-border-right-colors: none;
            -moz-border-top-colors: none;
            background: 0 0;
            border-color: #ddd #ddd rgba(0, 0, 0, 0);
            border-bottom: #f3f3f4;
            -webkit-border-image: none;
            -o-border-image: none;
            border-image: none;
            border-style: solid;
            border-width: 1px;
            color: #555;
            cursor: default
        }

        .nav.nav-tabs li {
            background: 0 0;
            border: none
        }

        .nav-tabs > li > a {
            color: #A7B1C2;
            font-weight: 600;
            padding: 10px 20px 10px 25px
        }

        .nav-tabs > li > a:focus, .nav-tabs > li > a:hover {
            background-color: #e6e6e6;
            color: #676a6c
        }

        .ui-tab .tab-content {
            padding: 20px 0
        }

        .no-padding {
            padding: 0 !important
        }

        .no-borders {
            border: none !important
        }

        .no-margins {
            margin: 0 !important
        }

        .no-top-border {
            border-top: 0 !important
        }

        .ibox-content.text-box {
            padding-bottom: 0;
            padding-top: 15px
        }

        .border-left-right {
            border-left: 1px solid #e7eaec;
            border-right: 1px solid #e7eaec;
            border-top: none;
            border-bottom: none
        }

        .border-left {
            border-left: 1px solid #e7eaec;
            border-right: none;
            border-top: none;
            border-bottom: none
        }

        .border-right {
            border-left: none;
            border-right: 1px solid #e7eaec;
            border-top: none;
            border-bottom: none
        }

        .full-width {
            width: 100% !important
        }

        .link-block {
            font-size: 12px;
            padding: 10px
        }

        .nav.navbar-top-links .link-block a {
            font-size: 12px
        }

        .link-block a {
            font-size: 10px;
            color: inherit
        }

        body.mini-navbar .branding {
            display: none
        }

        img.circle-border {
            border: 6px solid #FFF;
            border-radius: 50%
        }

        .branding {
            float: left;
            color: #FFF;
            font-size: 18px;
            font-weight: 600;
            padding: 17px 20px;
            text-align: center;
            background-color: #1ab394
        }

        .login-panel {
            margin-top: 25%
        }

        .page-header {
            padding: 20px 0 9px;
            margin: 0 0 20px;
            border-bottom: 1px solid #eee
        }

        .fontawesome-icon-list {
            margin-top: 22px
        }

        .fontawesome-icon-list .fa-hover a {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            display: block;
            color: #222;
            line-height: 32px;
            height: 32px;
            padding-left: 10px;
            border-radius: 4px
        }

        .fontawesome-icon-list .fa-hover a .fa {
            width: 32px;
            font-size: 14px;
            display: inline-block;
            text-align: right;
            margin-right: 10px
        }

        .fontawesome-icon-list .fa-hover a:hover {
            background-color: #1d9d74;
            color: #fff;
            text-decoration: none
        }

        .fontawesome-icon-list .fa-hover a:hover .fa {
            font-size: 30px;
            vertical-align: -6px
        }

        .fontawesome-icon-list .fa-hover a:hover .text-muted {
            color: #bbe2d5
        }

        .feature-list .col-md-4 {
            margin-bottom: 22px
        }

        .feature-list h4 .fa:before {
            vertical-align: -10%;
            font-size: 28px;
            display: inline-block;
            width: 1.07142857em;
            text-align: center;
            margin-right: 5px
        }

        .ui-draggable .ibox-title {
            cursor: move
        }

        .breadcrumb {
            background-color: #fff;
            padding: 0;
            margin-bottom: 0
        }

        .breadcrumb > .active, .breadcrumb > li a {
            color: inherit
        }

        code {
            background-color: #F9F2F4;
            border-radius: 4px;
            color: #ca4440;
            font-size: 90%;
            padding: 2px 4px;
            white-space: nowrap
        }

        .ibox {
            clear: both;
            margin-bottom: 25px;
            margin-top: 0;
            padding: 0
        }

        .ibox.collapsed .ibox-content {
            display: none
        }

        .ibox.collapsed .fa.fa-chevron-up:before {
            content: "\f078"
        }

        .ibox.collapsed .fa.fa-chevron-down:before {
            content: "\f077"
        }

        .ibox:after, .ibox:before {
            display: table
        }

        .ibox-title {
            -moz-border-bottom-colors: none;
            -moz-border-left-colors: none;
            -moz-border-right-colors: none;
            -moz-border-top-colors: none;
            background-color: #fff;
            border-color: #e7eaec;
            -webkit-border-image: none;
            -o-border-image: none;
            border-image: none;
            border-style: solid solid none;
            border-width: 4px 0 0;
            color: inherit;
            margin-bottom: 0;
            padding: 14px 15px 7px;
            min-height: 48px
        }

        .ibox-content {
            background-color: #fff;
            color: inherit;
            padding: 15px 20px 20px;
            border-color: #e7eaec;
            -webkit-border-image: none;
            -o-border-image: none;
            border-image: none;
            border-style: solid solid none;
            border-width: 1px 0
        }

        table.table-mail tr td {
            padding: 12px
        }

        .table-mail .check-mail {
            padding-left: 20px
        }

        .table-mail .mail-date {
            padding-right: 20px
        }

        .check-mail, .star-mail {
            width: 40px
        }

        .unread td, .unread td a {
            font-weight: 600;
            color: inherit
        }

        .read td, .read td a {
            font-weight: 400;
            color: inherit
        }

        .unread td {
            background-color: #f9f8f8
        }

        .ibox-content {
            clear: both
        }

        .ibox-heading {
            background-color: #f3f6fb;
            border-bottom: none
        }

        .ibox-heading h3 {
            font-weight: 200;
            font-size: 24px
        }

        .ibox-title h5 {
            display: inline-block;
            font-size: 14px;
            margin: 0 0 7px;
            padding: 0;
            text-overflow: ellipsis;
            float: left
        }

        .ibox-title .label {
            float: left;
            margin-left: 4px
        }

        .ibox-tools {
            display: inline-block;
            float: right;
            margin-top: 0;
            position: relative;
            padding: 0
        }

        .ibox-tools a {
            cursor: pointer;
            margin-left: 5px;
            color: #c4c4c4
        }

        .ibox-tools a.btn-primary {
            color: #fff
        }

        .ibox-tools .dropdown-menu > li > a {
            padding: 4px 10px;
            font-size: 12px
        }

        .ibox .open > .dropdown-menu {
            left: auto;
            right: 0
        }

        .gray-bg {
            background-color: #f3f3f4
        }

        .white-bg {
            background-color: #fff
        }

        .navy-bg {
            background-color: #1ab394;
            color: #fff
        }

        .blue-bg {
            background-color: #1c84c6;
            color: #fff
        }

        .lazur-bg {
            background-color: #23c6c8;
            color: #fff
        }

        .yellow-bg {
            background-color: #f8ac59;
            color: #fff
        }

        .red-bg {
            background-color: #ed5565;
            color: #fff
        }

        .black-bg {
            background-color: #262626
        }

        .panel-primary {
            border-color: #1ab394
        }

        .panel-primary > .panel-heading {
            background-color: #1ab394;
            border-color: #1ab394
        }

        .panel-success {
            border-color: #1c84c6
        }

        .panel-success > .panel-heading {
            background-color: #1c84c6;
            border-color: #1c84c6;
            color: #fff
        }

        .panel-info {
            border-color: #23c6c8
        }

        .panel-info > .panel-heading {
            background-color: #23c6c8;
            border-color: #23c6c8;
            color: #fff
        }

        .panel-warning {
            border-color: #f8ac59
        }

        .panel-warning > .panel-heading {
            background-color: #f8ac59;
            border-color: #f8ac59;
            color: #fff
        }

        .panel-danger {
            border-color: #ed5565
        }

        .panel-danger > .panel-heading {
            background-color: #ed5565;
            border-color: #ed5565;
            color: #fff
        }

        .progress-bar {
            background-color: #1ab394
        }

        .progress-small, .progress-small .progress-bar {
            height: 10px
        }

        .progress-mini, .progress-small {
            margin-top: 5px
        }

        .progress-mini, .progress-mini .progress-bar {
            height: 5px;
            margin-bottom: 0
        }

        .progress-bar-navy-light {
            background-color: #3dc7ab
        }

        .progress-bar-success {
            background-color: #1c84c6
        }

        .progress-bar-info {
            background-color: #23c6c8
        }

        .progress-bar-warning {
            background-color: #f8ac59
        }

        .progress-bar-danger {
            background-color: #ed5565
        }

        .panel-title {
            font-size: inherit
        }

        .jumbotron {
            border-radius: 6px;
            padding: 40px
        }

        .jumbotron h1 {
            margin-top: 0
        }

        .text-navy {
            color: #1ab394
        }

        .text-primary {
            color: inherit
        }

        .text-success {
            color: #1c84c6
        }

        .text-info {
            color: #23c6c8
        }

        .text-warning {
            color: #f8ac59
        }

        .text-danger {
            color: #ed5565
        }

        .text-muted {
            color: #888
        }

        .simple_tag {
            background-color: #f3f3f4;
            border: 1px solid #e7eaec;
            border-radius: 2px;
            color: inherit;
            font-size: 10px;
            margin-right: 5px;
            margin-top: 5px;
            padding: 5px 12px;
            display: inline-block
        }

        .img-shadow {
            box-shadow: 0 0 3px 0 #919191
        }

        .ComposeEmail .navbar.navbar-static-top, .Dashboard_2 .navbar.navbar-static-top, .Dashboard_3 .navbar.navbar-static-top, .Dashboard_4_1 .navbar.navbar-static-top, .EmailView .navbar.navbar-static-top, .Inbox .navbar.navbar-static-top, .dashboards\.dashboard_2 nav.navbar, .dashboards\.dashboard_3 nav.navbar, .dashboards\.dashboard_4_1 nav.navbar, .mailbox\.email_compose nav.navbar, .mailbox\.email_view nav.navbar, .mailbox\.inbox nav.navbar {
            background: #fff
        }

        a.close-canvas-menu {
            position: absolute;
            top: 10px;
            right: 15px;
            z-index: 1011;
            color: #a7b1c2
        }

        a.close-canvas-menu:hover {
            color: #fff
        }

        .full-height {
            height: 100%
        }

        .fh-breadcrumb {
            height: calc(100% - 196px);
            margin: 0 -15px;
            position: relative
        }

        .fh-no-breadcrumb {
            height: calc(100% - 99px);
            margin: 0 -15px;
            position: relative
        }

        .fh-column {
            background: #fff;
            height: 100%;
            width: 240px;
            float: left
        }

        .modal-backdrop {
            z-index: 2040 !important
        }

        .modal {
            z-index: 2050 !important
        }

        .spiner-example {
            height: 200px;
            padding-top: 70px
        }

        .p-xxs {
            padding: 5px
        }

        .p-xs {
            padding: 10px
        }

        .p-sm {
            padding: 15px
        }

        .p-m {
            padding: 20px
        }

        .p-md {
            padding: 25px
        }

        .p-lg {
            padding: 30px
        }

        .p-xl {
            padding: 40px
        }

        .m-xxs {
            margin: 2px 4px
        }

        .m-xs {
            margin: 5px
        }

        .m-sm {
            margin: 10px
        }

        .m {
            margin: 15px
        }

        .m-md {
            margin: 20px
        }

        .m-lg {
            margin: 30px
        }

        .m-xl {
            margin: 50px
        }

        .m-n {
            margin: 0 !important
        }

        .m-l-none {
            margin-left: 0
        }

        .m-l-xs {
            margin-left: 5px
        }

        .m-l-sm {
            margin-left: 10px
        }

        .m-l {
            margin-left: 15px
        }

        .m-l-md {
            margin-left: 20px
        }

        .m-l-lg {
            margin-left: 30px
        }

        .m-l-xl {
            margin-left: 40px
        }

        .m-l-n-xxs {
            margin-left: -1px
        }

        .m-l-n-xs {
            margin-left: -5px
        }

        .m-l-n-sm {
            margin-left: -10px
        }

        .m-l-n {
            margin-left: -15px
        }

        .m-l-n-md {
            margin-left: -20px
        }

        .m-l-n-lg {
            margin-left: -30px
        }

        .m-l-n-xl {
            margin-left: -40px
        }

        .m-t-none {
            margin-top: 0
        }

        .m-t-xxs {
            margin-top: 1px
        }

        .m-t-xs {
            margin-top: 5px
        }

        .m-t-sm {
            margin-top: 10px
        }

        .m-t {
            margin-top: 15px
        }

        .m-t-md {
            margin-top: 20px
        }

        .m-t-lg {
            margin-top: 30px
        }

        .m-t-xl {
            margin-top: 40px
        }

        .m-t-n-xxs {
            margin-top: -1px
        }

        .m-t-n-xs {
            margin-top: -5px
        }

        .m-t-n-sm {
            margin-top: -10px
        }

        .m-t-n {
            margin-top: -15px
        }

        .m-t-n-md {
            margin-top: -20px
        }

        .m-t-n-lg {
            margin-top: -30px
        }

        .m-t-n-xl {
            margin-top: -40px
        }

        .m-r-none {
            margin-right: 0
        }

        .m-r-xxs {
            margin-right: 1px
        }

        .m-r-xs {
            margin-right: 5px
        }

        .m-r-sm {
            margin-right: 10px
        }

        .m-r {
            margin-right: 15px
        }

        .m-r-md {
            margin-right: 20px
        }

        .m-r-lg {
            margin-right: 30px
        }

        .m-r-xl {
            margin-right: 40px
        }

        .m-r-n-xxs {
            margin-right: -1px
        }

        .m-r-n-xs {
            margin-right: -5px
        }

        .m-r-n-sm {
            margin-right: -10px
        }

        .m-r-n {
            margin-right: -15px
        }

        .m-r-n-md {
            margin-right: -20px
        }

        .m-r-n-lg {
            margin-right: -30px
        }

        .m-r-n-xl {
            margin-right: -40px
        }

        .m-b-none {
            margin-bottom: 0
        }

        .m-b-xxs {
            margin-bottom: 1px
        }

        .m-b-xs {
            margin-bottom: 5px
        }

        .m-b-sm {
            margin-bottom: 10px
        }

        .m-b {
            margin-bottom: 15px
        }

        .m-b-md {
            margin-bottom: 20px
        }

        .m-b-lg {
            margin-bottom: 30px
        }

        .m-b-xl {
            margin-bottom: 40px
        }

        .m-b-n-xxs {
            margin-bottom: -1px
        }

        .m-b-n-xs {
            margin-bottom: -5px
        }

        .m-b-n-sm {
            margin-bottom: -10px
        }

        .m-b-n {
            margin-bottom: -15px
        }

        .m-b-n-md {
            margin-bottom: -20px
        }

        .m-b-n-lg {
            margin-bottom: -30px
        }

        .m-b-n-xl {
            margin-bottom: -40px
        }

        .space-15 {
            margin: 15px 0
        }

        .space-20 {
            margin: 20px 0
        }

        .space-25 {
            margin: 25px 0
        }

        .space-30 {
            margin: 30px 0
        }

        body.modal-open {
            padding-right: inherit !important
        }

        .search-form {
            margin-top: 10px
        }

        .search-result h3 {
            margin-bottom: 0;
            color: #1E0FBE
        }

        .search-result .search-link {
            color: #006621
        }

        .search-result p {
            font-size: 12px;
            margin-top: 5px
        }

        .contact-box {
            background-color: #fff;
            border: 1px solid #e7eaec;
            padding: 20px;
            margin-bottom: 20px
        }

        .contact-box a {
            color: inherit
        }

        .invoice-table tbody > tr > td:last-child, .invoice-table tbody > tr > td:nth-child(2), .invoice-table tbody > tr > td:nth-child(3), .invoice-table tbody > tr > td:nth-child(4), .invoice-table thead > tr > th:last-child, .invoice-table thead > tr > th:nth-child(2), .invoice-table thead > tr > th:nth-child(3), .invoice-table thead > tr > th:nth-child(4), .invoice-total > tbody > tr > td:first-child {
            text-align: right
        }

        .invoice-total > tbody > tr > td {
            border: 0 none
        }

        .invoice-total > tbody > tr > td:last-child {
            border-bottom: 1px solid #DDD;
            text-align: right;
            width: 15%
        }

        .middle-box {
            max-width: 400px;
            z-index: 100;
            margin: 0 auto;
            padding-top: 40px
        }

        .lockscreen.middle-box {
            width: 200px;
            padding-top: 110px
        }

        .loginscreen.middle-box {
            width: 300px
        }

        .loginColumns {
            max-width: 800px;
            margin: 0 auto;
            padding: 100px 20px 20px
        }

        .passwordBox {
            max-width: 460px;
            margin: 0 auto;
            padding: 100px 20px 20px
        }

        .logo-name {
            color: #e6e6e6;
            font-size: 180px;
            font-weight: 800;
            letter-spacing: -10px;
            margin-bottom: 0
        }

        .middle-box h1 {
            font-size: 170px
        }

        .wrapper .middle-box {
            margin-top: 140px
        }

        .lock-word {
            z-index: 10;
            position: absolute;
            top: 110px;
            left: 50%;
            margin-left: -470px
        }

        .lock-word span {
            font-size: 100px;
            font-weight: 600;
            color: #e9e9e9;
            display: inline-block
        }

        .lock-word .first-word {
            margin-right: 160px
        }

        .dashboard-header {
            border-top: 0;
            padding: 20px
        }

        .dashboard-header h2 {
            margin-top: 10px;
            font-size: 26px
        }

        .fist-item {
            border-top: none !important
        }

        .statistic-box {
            margin-top: 40px
        }

        .dashboard-header .list-group-item span.label {
            margin-right: 10px
        }

        .list-group.clear-list .list-group-item {
            border-top: 1px solid #e7eaec;
            border-bottom: 0;
            border-right: 0;
            border-left: 0;
            padding: 10px 0
        }

        ul.clear-list:first-child {
            border-top: none !important
        }

        .timeline-item .date i {
            position: absolute;
            top: 0;
            right: 0;
            padding: 5px;
            width: 30px;
            text-align: center;
            border-top: 1px solid #e7eaec;
            border-bottom: 1px solid #e7eaec;
            border-left: 1px solid #e7eaec;
            background: #f8f8f8
        }

        .timeline-item .date {
            text-align: right;
            width: 110px;
            position: relative;
            padding-top: 30px
        }

        .timeline-item .content {
            border-left: 1px solid #e7eaec;
            border-top: 1px solid #e7eaec;
            padding-top: 10px;
            min-height: 100px
        }

        .timeline-item .content:hover {
            background: #f6f6f6
        }

        ul.notes li, ul.tag-list li {
            list-style: none
        }

        ul.notes li h4 {
            margin-top: 20px;
            font-size: 16px
        }

        ul.notes li div {
            position: relative
        }

        ul.notes li div small {
            position: absolute;
            top: 5px;
            right: 5px;
            font-size: 10px
        }

        ul.notes li div a {
            position: absolute;
            right: 10px;
            bottom: 10px;
            color: inherit
        }

        ul.notes li {
            margin: 10px 40px 50px 0;
            float: left
        }

        ul.notes li div p {
            font-size: 12px
        }

        ul.notes li div {
            -webkit-transform: rotate(-6deg);
            -o-transform: rotate(-6deg);
            -moz-transform: rotate(-6deg)
        }

        ul.notes li:nth-child(even) div {
            -o-transform: rotate(4deg);
            -webkit-transform: rotate(4deg);
            -moz-transform: rotate(4deg);
            position: relative;
            top: 5px
        }

        ul.notes li:nth-child(3n) div {
            -o-transform: rotate(-3deg);
            -webkit-transform: rotate(-3deg);
            -moz-transform: rotate(-3deg);
            position: relative;
            top: -5px
        }

        ul.notes li:nth-child(5n) div {
            -o-transform: rotate(5deg);
            -webkit-transform: rotate(5deg);
            -moz-transform: rotate(5deg);
            position: relative;
            top: -10px
        }

        ul.notes li div:focus, ul.notes li div:hover {
            -webkit-transform: scale(1.1);
            -moz-transform: scale(1.1);
            -o-transform: scale(1.1);
            position: relative;
            z-index: 5
        }

        ul.notes li div {
            text-decoration: none;
            color: #000;
            background: #ffc;
            display: block;
            height: 210px;
            width: 210px;
            padding: 1em;
            box-shadow: 5px 5px 7px rgba(33, 33, 33, .7);
            -webkit-transition: -webkit-transform .15s linear
        }

        .file-box {
            float: left;
            width: 220px
        }

        .file-manager h5 {
            text-transform: uppercase
        }

        .file-manager {
            list-style: none outside none;
            margin: 0;
            padding: 0
        }

        .folder-list li a {
            color: #666;
            display: block;
            padding: 5px 0
        }

        .folder-list li {
            border-bottom: 1px solid #e7eaec;
            display: block
        }

        .folder-list li i {
            margin-right: 8px;
            color: #3d4d5d
        }

        .category-list li a {
            color: #666;
            display: block;
            padding: 5px 0
        }

        .category-list li {
            display: block
        }

        .category-list li i {
            margin-right: 8px;
            color: #3d4d5d
        }

        .category-list li a .text-navy {
            color: #1ab394
        }

        .category-list li a .text-primary {
            color: #1c84c6
        }

        .category-list li a .text-info {
            color: #23c6c8
        }

        .category-list li a .text-danger {
            color: #EF5352
        }

        .category-list li a .text-warning {
            color: #F8AC59
        }

        .file-manager h5.tag-title {
            margin-top: 20px
        }

        .tag-list li {
            float: left
        }

        .tag-list li a {
            font-size: 10px;
            background-color: #f3f3f4;
            padding: 5px 12px;
            color: inherit;
            border-radius: 2px;
            border: 1px solid #e7eaec;
            margin-right: 5px;
            margin-top: 5px;
            display: block
        }

        .file {
            border: 1px solid #e7eaec;
            padding: 0;
            background-color: #fff;
            position: relative;
            margin-bottom: 20px;
            margin-right: 20px
        }

        .file-manager .hr-line-dashed {
            margin: 15px 0
        }

        .file .icon, .file .image {
            height: 100px;
            overflow: hidden
        }

        .file .icon {
            padding: 15px 10px;
            text-align: center
        }

        .file-control {
            color: inherit;
            font-size: 11px;
            margin-right: 10px
        }

        .file-control.active {
            text-decoration: underline
        }

        .file .icon i {
            font-size: 70px;
            color: #dadada
        }

        .file .file-name {
            padding: 10px;
            background-color: #f8f8f8;
            border-top: 1px solid #e7eaec
        }

        .file-name small {
            color: #676a6c
        }

        .corner {
            position: absolute;
            display: inline-block;
            width: 0;
            height: 0;
            line-height: 0;
            border: .6em solid transparent;
            border-right: .6em solid #f1f1f1;
            border-bottom: .6em solid #f1f1f1;
            right: 0;
            bottom: 0
        }

        a.compose-mail {
            padding: 8px 10px
        }

        .mail-search {
            max-width: 300px
        }

        .profile-content {
            border-top: none !important
        }

        .feed-activity-list .feed-element {
            border-bottom: 1px solid #e7eaec
        }

        .feed-element:first-child {
            margin-top: 0
        }

        .feed-element {
            padding-bottom: 15px
        }

        .feed-element, .feed-element .media {
            margin-top: 15px
        }

        .feed-element, .media-body {
            overflow: hidden
        }

        .feed-element > .pull-left {
            margin-right: 10px
        }

        .dropdown-messages-box img.img-circle, .feed-element img.img-circle {
            width: 38px;
            height: 38px
        }

        .feed-element .well {
            border: 1px solid #e7eaec;
            box-shadow: none;
            margin-top: 10px;
            margin-bottom: 5px;
            padding: 10px 20px;
            font-size: 11px;
            line-height: 16px
        }

        .feed-element .actions {
            margin-top: 10px
        }

        .feed-element .photos {
            margin: 10px 0
        }

        .feed-photo {
            max-height: 180px;
            border-radius: 4px;
            overflow: hidden;
            margin-right: 10px;
            margin-bottom: 10px
        }

        .mail-box {
            background-color: #fff;
            border: 1px solid #e7eaec;
            border-top: 0;
            padding: 0;
            margin-bottom: 20px
        }

        .mail-box-header {
            background-color: #fff;
            border: 1px solid #e7eaec;
            border-bottom: 0;
            padding: 30px 20px 20px
        }

        .mail-box-header h2 {
            margin-top: 0
        }

        .mailbox-content .tag-list li a {
            background: #fff
        }

        .mail-body {
            border-top: 1px solid #e7eaec;
            padding: 20px
        }

        .mail-text {
            border-top: 1px solid #e7eaec
        }

        .mail-text .note-toolbar {
            padding: 10px 15px
        }

        .mail-body .form-group {
            margin-bottom: 5px
        }

        .mail-text .note-editor .note-toolbar {
            background-color: #F9F8F8
        }

        .mail-attachment {
            border-top: 1px solid #e7eaec;
            padding: 20px;
            font-size: 12px
        }

        .mailbox-content {
            background: 0 0;
            border: none;
            padding: 10px
        }

        .mail-ontact {
            width: 23%
        }

        .project-actions, .project-people {
            text-align: right;
            vertical-align: middle
        }

        dd.project-people {
            text-align: left;
            margin-top: 5px
        }

        .project-people img {
            width: 32px;
            height: 32px
        }

        .project-title a {
            font-size: 14px;
            color: #676a6c;
            font-weight: 600
        }

        .project-list table tr td {
            border-top: none;
            border-bottom: 1px solid #e7eaec;
            padding: 15px 10px;
            vertical-align: middle
        }

        .project-manager .tag-list li a {
            font-size: 10px;
            background-color: #fff;
            padding: 5px 12px;
            color: inherit;
            border-radius: 2px;
            border: 1px solid #e7eaec;
            margin-right: 5px;
            margin-top: 5px;
            display: block
        }

        .project-files li a {
            font-size: 11px;
            color: #676a6c;
            margin-left: 10px;
            line-height: 22px
        }

        .faq-item {
            padding: 20px;
            margin-bottom: 2px;
            background: #fff
        }

        .faq-question {
            font-size: 18px;
            font-weight: 600;
            color: #1ab394;
            display: block
        }

        .faq-question:hover {
            color: #179d82
        }

        .faq-answer {
            margin-top: 10px;
            background: #f3f3f4;
            border: 1px solid #e7eaec;
            border-radius: 3px;
            padding: 15px
        }

        .faq-item .tag-item {
            background: #f3f3f4;
            padding: 2px 6px;
            font-size: 10px;
            text-transform: uppercase
        }

        .message-input {
            height: 90px !important
        }

        .chat-avatar {
            white: 36px;
            height: 36px;
            float: left;
            margin-right: 10px
        }

        .chat-user-name {
            padding: 10px
        }

        .chat-user {
            padding: 8px 10px;
            border-bottom: 1px solid #e7eaec
        }

        .chat-user a {
            color: inherit
        }

        .chat-view {
            z-index: 20012
        }

        .chat-statistic, .chat-users {
            margin-left: -30px
        }

        @media (max-width: 992px) {
            .chat-statistic, .chat-users {
                margin-left: 0
            }
        }

        .chat-view .ibox-content {
            padding: 0
        }

        .chat-message {
            padding: 10px 20px
        }

        .message-avatar {
            height: 48px;
            width: 48px;
            border: 1px solid #e7eaec;
            border-radius: 4px;
            margin-top: 1px
        }

        .chat-discussion .chat-message:nth-child(2n+1) .message-avatar {
            float: left;
            margin-right: 10px
        }

        .chat-discussion .chat-message:nth-child(2n) .message-avatar {
            float: right;
            margin-left: 10px
        }

        .message {
            background-color: #fff;
            border: 1px solid #e7eaec;
            text-align: left;
            display: block;
            padding: 10px 20px;
            position: relative;
            border-radius: 4px
        }

        .chat-discussion .chat-message:nth-child(2n+1) .message-date {
            float: right
        }

        .chat-discussion .chat-message:nth-child(2n) .message-date {
            float: left
        }

        .chat-discussion .chat-message:nth-child(2n+1) .message {
            text-align: left;
            margin-left: 55px
        }

        .chat-discussion .chat-message:nth-child(2n) .message {
            text-align: right;
            margin-right: 55px
        }

        .message-date {
            font-size: 10px;
            color: #888
        }

        .message-content {
            display: block
        }

        .chat-discussion {
            background: #eee;
            padding: 15px;
            height: 400px;
            overflow-y: auto
        }

        .chat-users {
            overflow-y: auto;
            height: 400px
        }

        .chat-message-form .form-group {
            margin-bottom: 0
        }

        .jstree-open > .jstree-anchor > .fa-folder:before {
            content: "\f07c"
        }

        .jstree-default .jstree-icon.none {
            width: 0
        }

        .clients-list {
            margin-top: 20px
        }

        .clients-list .tab-pane {
            position: relative;
            height: 600px
        }

        .client-detail {
            position: relative;
            height: 620px
        }

        .clients-list table tr td {
            height: 46px;
            vertical-align: middle;
            border: none
        }

        .client-link {
            font-weight: 600;
            color: inherit
        }

        .client-link:hover {
            color: inherit
        }

        .client-avatar {
            width: 42px
        }

        .client-avatar img {
            width: 28px;
            height: 28px;
            border-radius: 50%
        }

        .contact-type {
            width: 20px;
            color: #c1c3c4
        }

        .client-status {
            text-align: left
        }

        .client-detail .vertical-timeline-content p {
            margin: 0
        }

        .client-detail .vertical-timeline-icon.gray-bg {
            color: #a7aaab
        }

        .clients-list .nav-tabs > li.active > a, .clients-list .nav-tabs > li.active > a:focus, .clients-list .nav-tabs > li.active > a:hover {
            border-bottom: 1px solid #fff
        }

        .blog h2 {
            font-weight: 700
        }

        .blog .btn, .blog h5 {
            margin: 0 0 5px
        }

        .article h1 {
            font-size: 48px;
            font-weight: 700;
            color: #2F4050
        }

        .article p {
            font-size: 15px;
            line-height: 26px
        }

        .article-title {
            text-align: center;
            margin: 60px 0 40px
        }

        .article .ibox-content {
            padding: 40px
        }

        .issue-tracker .btn-link {
            color: #1ab394
        }

        table.issue-tracker tbody tr td {
            vertical-align: middle;
            height: 50px
        }

        .issue-info {
            width: 50%
        }

        .issue-info a {
            font-weight: 600;
            color: #676a6c
        }

        .issue-info small {
            display: block
        }

        .team-members {
            margin: 10px 0
        }

        .team-members img.img-circle {
            width: 42px;
            height: 42px;
            margin-bottom: 5px
        }

        .sortable-list {
            padding: 10px 0
        }

        .agile-list {
            list-style: none;
            margin: 0
        }

        .agile-list li {
            background: #FAFAFB;
            border: 1px solid #e7eaec;
            margin: 0 0 10px;
            padding: 10px;
            border-radius: 2px
        }

        .agile-list li:hover {
            cursor: pointer;
            background: #fff
        }

        .agile-list li.warning-element {
            border-left: 3px solid #f8ac59
        }

        .agile-list li.danger-element {
            border-left: 3px solid #ed5565
        }

        .agile-list li.info-element {
            border-left: 3px solid #1c84c6
        }

        .agile-list li.success-element {
            border-left: 3px solid #1ab394
        }

        .agile-detail {
            margin-top: 5px;
            font-size: 12px
        }

        ins {
            background-color: #c6ffc6;
            text-decoration: none
        }

        del {
            background-color: #ffc6c6
        }

        #small-chat {
            position: fixed;
            bottom: 50px;
            right: 26px;
            z-index: 100
        }

        #small-chat .badge {
            position: absolute;
            top: -3px;
            right: -4px
        }

        .open-small-chat {
            height: 38px;
            width: 38px;
            display: block;
            background: #1ab394;
            padding: 9px 8px;
            text-align: center;
            color: #fff;
            border-radius: 50%
        }

        .open-small-chat:hover {
            color: #fff;
            background: #1ab394
        }

        .small-chat-box {
            display: none;
            position: fixed;
            bottom: 50px;
            right: 80px;
            background: #fff;
            border: 1px solid #e7eaec;
            width: 230px;
            height: 320px;
            border-radius: 4px
        }

        .small-chat-box.ng-small-chat {
            display: block
        }

        .body-small .small-chat-box {
            bottom: 70px;
            right: 20px
        }

        .small-chat-box.active {
            display: block
        }

        .small-chat-box .heading {
            background: #2f4050;
            padding: 8px 15px;
            font-weight: 700;
            color: #fff
        }

        .small-chat-box .chat-date {
            opacity: .6;
            font-size: 10px;
            font-weight: 400
        }

        .small-chat-box .content {
            padding: 15px
        }

        .small-chat-box .content .author-name {
            font-weight: 700;
            margin-bottom: 3px;
            font-size: 11px
        }

        .small-chat-box .content > div {
            padding-bottom: 20px
        }

        .small-chat-box .content .chat-message {
            padding: 5px 10px;
            border-radius: 6px;
            font-size: 11px;
            line-height: 14px;
            max-width: 80%;
            background: #f3f3f4;
            margin-bottom: 10px
        }

        .small-chat-box .content .chat-message.active {
            background: #1ab394;
            color: #fff
        }

        .small-chat-box .content .left {
            text-align: left;
            clear: both
        }

        .small-chat-box .content .left .chat-message {
            float: left
        }

        .small-chat-box .content .right {
            text-align: right;
            clear: both
        }

        .small-chat-box .content .right .chat-message {
            float: right
        }

        .small-chat-box .form-chat {
            padding: 10px
        }

        .sk-spinner-rotating-plane.sk-spinner {
            width: 30px;
            height: 30px;
            background-color: #1ab394;
            margin: 0 auto;
            -webkit-animation: sk-rotatePlane 1.2s infinite ease-in-out;
            animation: sk-rotatePlane 1.2s infinite ease-in-out
        }

        @-webkit-keyframes sk-rotatePlane {
            0% {
                -webkit-transform: perspective(120px) rotateX(0deg) rotateY(0deg);
                transform: perspective(120px) rotateX(0deg) rotateY(0deg)
            }

            50% {
                -webkit-transform: perspective(120px) rotateX(-180.1deg) rotateY(0deg);
                transform: perspective(120px) rotateX(-180.1deg) rotateY(0deg)
            }

            100% {
                -webkit-transform: perspective(120px) rotateX(-180deg) rotateY(-179.9deg);
                transform: perspective(120px) rotateX(-180deg) rotateY(-179.9deg)
            }
        }

        @keyframes sk-rotatePlane {
            0% {
                -webkit-transform: perspective(120px) rotateX(0deg) rotateY(0deg);
                transform: perspective(120px) rotateX(0deg) rotateY(0deg)
            }

            50% {
                -webkit-transform: perspective(120px) rotateX(-180.1deg) rotateY(0deg);
                transform: perspective(120px) rotateX(-180.1deg) rotateY(0deg)
            }

            100% {
                -webkit-transform: perspective(120px) rotateX(-180deg) rotateY(-179.9deg);
                transform: perspective(120px) rotateX(-180deg) rotateY(-179.9deg)
            }
        }

        .sk-spinner-double-bounce.sk-spinner {
            width: 40px;
            height: 40px;
            position: relative;
            margin: 0 auto
        }

        .sk-spinner-double-bounce .sk-double-bounce1, .sk-spinner-double-bounce .sk-double-bounce2 {
            width: 100%;
            height: 100%;
            border-radius: 50%;
            background-color: #1ab394;
            opacity: .6;
            position: absolute;
            top: 0;
            left: 0;
            -webkit-animation: sk-doubleBounce 2s infinite ease-in-out;
            animation: sk-doubleBounce 2s infinite ease-in-out
        }

        .sk-spinner-double-bounce .sk-double-bounce2 {
            -webkit-animation-delay: -1s;
            animation-delay: -1s
        }

        @-webkit-keyframes sk-doubleBounce {
            0%, 100% {
                -webkit-transform: scale(0);
                transform: scale(0)
            }

            50% {
                -webkit-transform: scale(1);
                transform: scale(1)
            }
        }

        @keyframes sk-doubleBounce {
            0%, 100% {
                -webkit-transform: scale(0);
                transform: scale(0)
            }

            50% {
                -webkit-transform: scale(1);
                transform: scale(1)
            }
        }

        .sk-spinner-wave.sk-spinner {
            margin: 0 auto;
            width: 50px;
            height: 30px;
            text-align: center;
            font-size: 10px
        }

        .sk-spinner-wave div {
            background-color: #1ab394;
            height: 100%;
            width: 6px;
            display: inline-block;
            -webkit-animation: sk-waveStretchDelay 1.2s infinite ease-in-out;
            animation: sk-waveStretchDelay 1.2s infinite ease-in-out
        }

        .sk-spinner-wave .sk-rect2 {
            -webkit-animation-delay: -1.1s;
            animation-delay: -1.1s
        }

        .sk-spinner-wave .sk-rect3 {
            -webkit-animation-delay: -1s;
            animation-delay: -1s
        }

        .sk-spinner-wave .sk-rect4 {
            -webkit-animation-delay: -.9s;
            animation-delay: -.9s
        }

        .sk-spinner-wave .sk-rect5 {
            -webkit-animation-delay: -.8s;
            animation-delay: -.8s
        }

        @-webkit-keyframes sk-waveStretchDelay {
            0%, 100%, 40% {
                -webkit-transform: scaleY(0.4);
                transform: scaleY(0.4)
            }

            20% {
                -webkit-transform: scaleY(1);
                transform: scaleY(1)
            }
        }

        @keyframes sk-waveStretchDelay {
            0%, 100%, 40% {
                -webkit-transform: scaleY(0.4);
                transform: scaleY(0.4)
            }

            20% {
                -webkit-transform: scaleY(1);
                transform: scaleY(1)
            }
        }

        .sk-spinner-wandering-cubes.sk-spinner {
            margin: 0 auto;
            width: 32px;
            height: 32px;
            position: relative
        }

        .sk-spinner-wandering-cubes .sk-cube1, .sk-spinner-wandering-cubes .sk-cube2 {
            background-color: #1ab394;
            width: 10px;
            height: 10px;
            position: absolute;
            top: 0;
            left: 0;
            -webkit-animation: sk-wanderingCubeMove 1.8s infinite ease-in-out;
            animation: sk-wanderingCubeMove 1.8s infinite ease-in-out
        }

        .sk-spinner-wandering-cubes .sk-cube2 {
            -webkit-animation-delay: -.9s;
            animation-delay: -.9s
        }

        @-webkit-keyframes sk-wanderingCubeMove {
            25% {
                -webkit-transform: translateX(42px) rotate(-90deg) scale(0.5);
                transform: translateX(42px) rotate(-90deg) scale(0.5)
            }

            50% {
                -webkit-transform: translateX(42px) translateY(42px) rotate(-179deg);
                transform: translateX(42px) translateY(42px) rotate(-179deg)
            }

            50.1% {
                -webkit-transform: translateX(42px) translateY(42px) rotate(-180deg);
                transform: translateX(42px) translateY(42px) rotate(-180deg)
            }

            75% {
                -webkit-transform: translateX(0px) translateY(42px) rotate(-270deg) scale(0.5);
                transform: translateX(0px) translateY(42px) rotate(-270deg) scale(0.5)
            }

            100% {
                -webkit-transform: rotate(-360deg);
                transform: rotate(-360deg)
            }
        }

        @keyframes sk-wanderingCubeMove {
            25% {
                -webkit-transform: translateX(42px) rotate(-90deg) scale(0.5);
                transform: translateX(42px) rotate(-90deg) scale(0.5)
            }

            50% {
                -webkit-transform: translateX(42px) translateY(42px) rotate(-179deg);
                transform: translateX(42px) translateY(42px) rotate(-179deg)
            }

            50.1% {
                -webkit-transform: translateX(42px) translateY(42px) rotate(-180deg);
                transform: translateX(42px) translateY(42px) rotate(-180deg)
            }

            75% {
                -webkit-transform: translateX(0px) translateY(42px) rotate(-270deg) scale(0.5);
                transform: translateX(0px) translateY(42px) rotate(-270deg) scale(0.5)
            }

            100% {
                -webkit-transform: rotate(-360deg);
                transform: rotate(-360deg)
            }
        }

        .sk-spinner-pulse.sk-spinner {
            width: 40px;
            height: 40px;
            margin: 0 auto;
            background-color: #1ab394;
            border-radius: 100%;
            -webkit-animation: sk-pulseScaleOut 1s infinite ease-in-out;
            animation: sk-pulseScaleOut 1s infinite ease-in-out
        }

        @-webkit-keyframes sk-pulseScaleOut {
            0% {
                -webkit-transform: scale(0);
                transform: scale(0)
            }

            100% {
                -webkit-transform: scale(1);
                transform: scale(1);
                opacity: 0
            }
        }

        @keyframes sk-pulseScaleOut {
            0% {
                -webkit-transform: scale(0);
                transform: scale(0)
            }

            100% {
                -webkit-transform: scale(1);
                transform: scale(1);
                opacity: 0
            }
        }

        .sk-spinner-chasing-dots.sk-spinner {
            margin: 0 auto;
            width: 40px;
            height: 40px;
            position: relative;
            text-align: center;
            -webkit-animation: sk-chasingDotsRotate 2s infinite linear;
            animation: sk-chasingDotsRotate 2s infinite linear
        }

        .sk-spinner-chasing-dots .sk-dot1, .sk-spinner-chasing-dots .sk-dot2 {
            width: 60%;
            height: 60%;
            display: inline-block;
            position: absolute;
            top: 0;
            background-color: #1ab394;
            border-radius: 100%;
            -webkit-animation: sk-chasingDotsBounce 2s infinite ease-in-out;
            animation: sk-chasingDotsBounce 2s infinite ease-in-out
        }

        .sk-spinner-chasing-dots .sk-dot2 {
            top: auto;
            bottom: 0;
            -webkit-animation-delay: -1s;
            animation-delay: -1s
        }

        @-webkit-keyframes sk-chasingDotsRotate {
            100% {
                -webkit-transform: rotate(360deg);
                transform: rotate(360deg)
            }
        }

        @keyframes sk-chasingDotsRotate {
            100% {
                -webkit-transform: rotate(360deg);
                transform: rotate(360deg)
            }
        }

        @-webkit-keyframes sk-chasingDotsBounce {
            0%, 100% {
                -webkit-transform: scale(0);
                transform: scale(0)
            }

            50% {
                -webkit-transform: scale(1);
                transform: scale(1)
            }
        }

        @keyframes sk-chasingDotsBounce {
            0%, 100% {
                -webkit-transform: scale(0);
                transform: scale(0)
            }

            50% {
                -webkit-transform: scale(1);
                transform: scale(1)
            }
        }

        .sk-spinner-three-bounce.sk-spinner {
            margin: 0 auto;
            width: 70px;
            text-align: center
        }

        .sk-spinner-three-bounce div {
            width: 18px;
            height: 18px;
            background-color: #1ab394;
            border-radius: 100%;
            display: inline-block;
            -webkit-animation: sk-threeBounceDelay 1.4s infinite ease-in-out;
            animation: sk-threeBounceDelay 1.4s infinite ease-in-out;
            -webkit-animation-fill-mode: both;
            animation-fill-mode: both
        }

        .sk-spinner-three-bounce .sk-bounce1 {
            -webkit-animation-delay: -.32s;
            animation-delay: -.32s
        }

        .sk-spinner-three-bounce .sk-bounce2 {
            -webkit-animation-delay: -.16s;
            animation-delay: -.16s
        }

        @-webkit-keyframes sk-threeBounceDelay {
            0%, 100%, 80% {
                -webkit-transform: scale(0);
                transform: scale(0)
            }

            40% {
                -webkit-transform: scale(1);
                transform: scale(1)
            }
        }

        @keyframes sk-threeBounceDelay {
            0%, 100%, 80% {
                -webkit-transform: scale(0);
                transform: scale(0)
            }

            40% {
                -webkit-transform: scale(1);
                transform: scale(1)
            }
        }

        .sk-spinner-circle.sk-spinner {
            margin: 0 auto;
            width: 22px;
            height: 22px;
            position: relative
        }

        .sk-spinner-circle .sk-circle {
            width: 100%;
            height: 100%;
            position: absolute;
            left: 0;
            top: 0
        }

        .sk-spinner-circle .sk-circle:before {
            content: '';
            display: block;
            margin: 0 auto;
            width: 20%;
            height: 20%;
            background-color: #1ab394;
            border-radius: 100%;
            -webkit-animation: sk-circleBounceDelay 1.2s infinite ease-in-out;
            animation: sk-circleBounceDelay 1.2s infinite ease-in-out;
            -webkit-animation-fill-mode: both;
            animation-fill-mode: both
        }

        .sk-spinner-circle .sk-circle2 {
            -webkit-transform: rotate(30deg);
            -ms-transform: rotate(30deg);
            transform: rotate(30deg)
        }

        .sk-spinner-circle .sk-circle3 {
            -webkit-transform: rotate(60deg);
            -ms-transform: rotate(60deg);
            transform: rotate(60deg)
        }

        .sk-spinner-circle .sk-circle4 {
            -webkit-transform: rotate(90deg);
            -ms-transform: rotate(90deg);
            transform: rotate(90deg)
        }

        .sk-spinner-circle .sk-circle5 {
            -webkit-transform: rotate(120deg);
            -ms-transform: rotate(120deg);
            transform: rotate(120deg)
        }

        .sk-spinner-circle .sk-circle6 {
            -webkit-transform: rotate(150deg);
            -ms-transform: rotate(150deg);
            transform: rotate(150deg)
        }

        .sk-spinner-circle .sk-circle7 {
            -webkit-transform: rotate(180deg);
            -ms-transform: rotate(180deg);
            transform: rotate(180deg)
        }

        .sk-spinner-circle .sk-circle8 {
            -webkit-transform: rotate(210deg);
            -ms-transform: rotate(210deg);
            transform: rotate(210deg)
        }

        .sk-spinner-circle .sk-circle9 {
            -webkit-transform: rotate(240deg);
            -ms-transform: rotate(240deg);
            transform: rotate(240deg)
        }

        .sk-spinner-circle .sk-circle10 {
            -webkit-transform: rotate(270deg);
            -ms-transform: rotate(270deg);
            transform: rotate(270deg)
        }

        .sk-spinner-circle .sk-circle11 {
            -webkit-transform: rotate(300deg);
            -ms-transform: rotate(300deg);
            transform: rotate(300deg)
        }

        .sk-spinner-circle .sk-circle12 {
            -webkit-transform: rotate(330deg);
            -ms-transform: rotate(330deg);
            transform: rotate(330deg)
        }

        .sk-spinner-circle .sk-circle2:before {
            -webkit-animation-delay: -1.1s;
            animation-delay: -1.1s
        }

        .sk-spinner-circle .sk-circle3:before {
            -webkit-animation-delay: -1s;
            animation-delay: -1s
        }

        .sk-spinner-circle .sk-circle4:before {
            -webkit-animation-delay: -.9s;
            animation-delay: -.9s
        }

        .sk-spinner-circle .sk-circle5:before {
            -webkit-animation-delay: -.8s;
            animation-delay: -.8s
        }

        .sk-spinner-circle .sk-circle6:before {
            -webkit-animation-delay: -.7s;
            animation-delay: -.7s
        }

        .sk-spinner-circle .sk-circle7:before {
            -webkit-animation-delay: -.6s;
            animation-delay: -.6s
        }

        .sk-spinner-circle .sk-circle8:before {
            -webkit-animation-delay: -.5s;
            animation-delay: -.5s
        }

        .sk-spinner-circle .sk-circle9:before {
            -webkit-animation-delay: -.4s;
            animation-delay: -.4s
        }

        .sk-spinner-circle .sk-circle10:before {
            -webkit-animation-delay: -.3s;
            animation-delay: -.3s
        }

        .sk-spinner-circle .sk-circle11:before {
            -webkit-animation-delay: -.2s;
            animation-delay: -.2s
        }

        .sk-spinner-circle .sk-circle12:before {
            -webkit-animation-delay: -.1s;
            animation-delay: -.1s
        }

        @-webkit-keyframes sk-circleBounceDelay {
            0%, 100%, 80% {
                -webkit-transform: scale(0);
                transform: scale(0)
            }

            40% {
                -webkit-transform: scale(1);
                transform: scale(1)
            }
        }

        @keyframes sk-circleBounceDelay {
            0%, 100%, 80% {
                -webkit-transform: scale(0);
                transform: scale(0)
            }

            40% {
                -webkit-transform: scale(1);
                transform: scale(1)
            }
        }

        .sk-spinner-cube-grid.sk-spinner {
            width: 30px;
            height: 30px;
            margin: 0 auto
        }

        .sk-spinner-cube-grid .sk-cube {
            width: 33%;
            height: 33%;
            background-color: #1ab394;
            float: left;
            -webkit-animation: sk-cubeGridScaleDelay 1.3s infinite ease-in-out;
            animation: sk-cubeGridScaleDelay 1.3s infinite ease-in-out
        }

        .sk-spinner-cube-grid .sk-cube:nth-child(1) {
            -webkit-animation-delay: .2s;
            animation-delay: .2s
        }

        .sk-spinner-cube-grid .sk-cube:nth-child(2) {
            -webkit-animation-delay: .3s;
            animation-delay: .3s
        }

        .sk-spinner-cube-grid .sk-cube:nth-child(3) {
            -webkit-animation-delay: .4s;
            animation-delay: .4s
        }

        .sk-spinner-cube-grid .sk-cube:nth-child(4) {
            -webkit-animation-delay: .1s;
            animation-delay: .1s
        }

        .sk-spinner-cube-grid .sk-cube:nth-child(5) {
            -webkit-animation-delay: .2s;
            animation-delay: .2s
        }

        .sk-spinner-cube-grid .sk-cube:nth-child(6) {
            -webkit-animation-delay: .3s;
            animation-delay: .3s
        }

        .sk-spinner-cube-grid .sk-cube:nth-child(7) {
            -webkit-animation-delay: 0s;
            animation-delay: 0s
        }

        .sk-spinner-cube-grid .sk-cube:nth-child(8) {
            -webkit-animation-delay: .1s;
            animation-delay: .1s
        }

        .sk-spinner-cube-grid .sk-cube:nth-child(9) {
            -webkit-animation-delay: .2s;
            animation-delay: .2s
        }

        @-webkit-keyframes sk-cubeGridScaleDelay {
            0%, 100%, 70% {
                -webkit-transform: scale3D(1, 1, 1);
                transform: scale3D(1, 1, 1)
            }

            35% {
                -webkit-transform: scale3D(0, 0, 1);
                transform: scale3D(0, 0, 1)
            }
        }

        @keyframes sk-cubeGridScaleDelay {
            0%, 100%, 70% {
                -webkit-transform: scale3D(1, 1, 1);
                transform: scale3D(1, 1, 1)
            }

            35% {
                -webkit-transform: scale3D(0, 0, 1);
                transform: scale3D(0, 0, 1)
            }
        }

        .sk-spinner-wordpress.sk-spinner {
            background-color: #1ab394;
            width: 30px;
            height: 30px;
            border-radius: 30px;
            position: relative;
            margin: 0 auto;
            -webkit-animation: sk-innerCircle 1s linear infinite;
            animation: sk-innerCircle 1s linear infinite
        }

        .sk-spinner-wordpress .sk-inner-circle {
            display: block;
            background-color: #fff;
            width: 8px;
            height: 8px;
            position: absolute;
            border-radius: 8px;
            top: 5px;
            left: 5px
        }

        @-webkit-keyframes sk-innerCircle {
            0% {
                -webkit-transform: rotate(0);
                transform: rotate(0)
            }

            100% {
                -webkit-transform: rotate(360deg);
                transform: rotate(360deg)
            }
        }

        @keyframes sk-innerCircle {
            0% {
                -webkit-transform: rotate(0);
                transform: rotate(0)
            }

            100% {
                -webkit-transform: rotate(360deg);
                transform: rotate(360deg)
            }
        }

        .sk-spinner-fading-circle.sk-spinner {
            margin: 0 auto;
            width: 22px;
            height: 22px;
            position: relative
        }

        .sk-spinner-fading-circle .sk-circle {
            width: 100%;
            height: 100%;
            position: absolute;
            left: 0;
            top: 0
        }

        .sk-spinner-fading-circle .sk-circle:before {
            content: '';
            display: block;
            margin: 0 auto;
            width: 18%;
            height: 18%;
            background-color: #1ab394;
            border-radius: 100%;
            -webkit-animation: sk-circleFadeDelay 1.2s infinite ease-in-out;
            animation: sk-circleFadeDelay 1.2s infinite ease-in-out;
            -webkit-animation-fill-mode: both;
            animation-fill-mode: both
        }

        .sk-spinner-fading-circle .sk-circle2 {
            -webkit-transform: rotate(30deg);
            -ms-transform: rotate(30deg);
            transform: rotate(30deg)
        }

        .sk-spinner-fading-circle .sk-circle3 {
            -webkit-transform: rotate(60deg);
            -ms-transform: rotate(60deg);
            transform: rotate(60deg)
        }

        .sk-spinner-fading-circle .sk-circle4 {
            -webkit-transform: rotate(90deg);
            -ms-transform: rotate(90deg);
            transform: rotate(90deg)
        }

        .sk-spinner-fading-circle .sk-circle5 {
            -webkit-transform: rotate(120deg);
            -ms-transform: rotate(120deg);
            transform: rotate(120deg)
        }

        .sk-spinner-fading-circle .sk-circle6 {
            -webkit-transform: rotate(150deg);
            -ms-transform: rotate(150deg);
            transform: rotate(150deg)
        }

        .sk-spinner-fading-circle .sk-circle7 {
            -webkit-transform: rotate(180deg);
            -ms-transform: rotate(180deg);
            transform: rotate(180deg)
        }

        .sk-spinner-fading-circle .sk-circle8 {
            -webkit-transform: rotate(210deg);
            -ms-transform: rotate(210deg);
            transform: rotate(210deg)
        }

        .sk-spinner-fading-circle .sk-circle9 {
            -webkit-transform: rotate(240deg);
            -ms-transform: rotate(240deg);
            transform: rotate(240deg)
        }

        .sk-spinner-fading-circle .sk-circle10 {
            -webkit-transform: rotate(270deg);
            -ms-transform: rotate(270deg);
            transform: rotate(270deg)
        }

        .sk-spinner-fading-circle .sk-circle11 {
            -webkit-transform: rotate(300deg);
            -ms-transform: rotate(300deg);
            transform: rotate(300deg)
        }

        .sk-spinner-fading-circle .sk-circle12 {
            -webkit-transform: rotate(330deg);
            -ms-transform: rotate(330deg);
            transform: rotate(330deg)
        }

        .sk-spinner-fading-circle .sk-circle2:before {
            -webkit-animation-delay: -1.1s;
            animation-delay: -1.1s
        }

        .sk-spinner-fading-circle .sk-circle3:before {
            -webkit-animation-delay: -1s;
            animation-delay: -1s
        }

        .sk-spinner-fading-circle .sk-circle4:before {
            -webkit-animation-delay: -.9s;
            animation-delay: -.9s
        }

        .sk-spinner-fading-circle .sk-circle5:before {
            -webkit-animation-delay: -.8s;
            animation-delay: -.8s
        }

        .sk-spinner-fading-circle .sk-circle6:before {
            -webkit-animation-delay: -.7s;
            animation-delay: -.7s
        }

        .sk-spinner-fading-circle .sk-circle7:before {
            -webkit-animation-delay: -.6s;
            animation-delay: -.6s
        }

        .sk-spinner-fading-circle .sk-circle8:before {
            -webkit-animation-delay: -.5s;
            animation-delay: -.5s
        }

        .sk-spinner-fading-circle .sk-circle9:before {
            -webkit-animation-delay: -.4s;
            animation-delay: -.4s
        }

        .sk-spinner-fading-circle .sk-circle10:before {
            -webkit-animation-delay: -.3s;
            animation-delay: -.3s
        }

        .sk-spinner-fading-circle .sk-circle11:before {
            -webkit-animation-delay: -.2s;
            animation-delay: -.2s
        }

        .sk-spinner-fading-circle .sk-circle12:before {
            -webkit-animation-delay: -.1s;
            animation-delay: -.1s
        }

        @-webkit-keyframes sk-circleFadeDelay {
            0%, 100%, 39% {
                opacity: 0
            }

            40% {
                opacity: 1
            }
        }

        @keyframes sk-circleFadeDelay {
            0%, 100%, 39% {
                opacity: 0
            }

            40% {
                opacity: 1
            }
        }

        body.rtls #page-wrapper {
            margin: 0 220px 0 0
        }

        body.rtls .nav-second-level li a {
            padding: 7px 35px 7px 10px
        }

        body.rtls .ibox-title h5 {
            float: right
        }

        body.rtls .pull-right {
            float: left !important
        }

        body.rtls .pull-left {
            float: right !important
        }

        body.rtls .ibox-tools, body.rtls .stat-percent {
            float: left
        }

        body.rtls .navbar-right {
            float: left !important
        }

        body.rtls .navbar-top-links li:last-child {
            margin-right: 0
        }

        body.rtls .minimalize-styl-2 {
            float: right;
            margin: 14px 20px 5px 5px
        }

        body.rtls .feed-element > .pull-left {
            margin-left: 10px;
            margin-right: 0
        }

        body.rtls .timeline-item .date {
            text-align: left
        }

        body.rtls .timeline-item .date i {
            left: 0;
            right: auto
        }

        body.rtls .timeline-item .content {
            border-right: 1px solid #e7eaec;
            border-left: none
        }

        body.rtls .toast-close-button {
            float: left
        }

        body.rtls #toast-container > .toast:before {
            margin: auto -1.5em auto .5em
        }

        body.rtls #toast-container > div {
            padding: 15px 50px 15px 15px
        }

        body.rtls .center-orientation .vertical-timeline-icon i {
            margin-left: 0;
            margin-right: -12px
        }

        body.rtls .vertical-timeline-icon i {
            right: 50%;
            left: auto;
            margin-left: auto;
            margin-right: -12px
        }

        body.rtls .file-box, body.rtls ul.notes li {
            float: right
        }

        body.rtls .chat-statistic, body.rtls .chat-users {
            margin-right: -30px;
            margin-left: auto
        }

        body.rtls .dropdown-menu > li > a {
            text-align: right
        }

        body.rtls .b-r {
            border-left: 1px solid #e7eaec;
            border-right: none
        }

        body.rtls .dd-list .dd-list {
            padding-right: 30px;
            padding-left: 0
        }

        body.rtls .dd-item > button {
            float: right
        }

        body.rtls .skin-setttings {
            margin-right: 40px;
            margin-left: 0;
            direction: ltr
        }

        body.rtls .footer.fixed {
            margin-right: 220px;
            margin-left: 0
        }

        @media (max-width: 992px) {
            body.rtls .chat-statistic, body.rtls .chat-users {
                margin-right: 0
            }
        }

        body.body-small.mini-navbar .footer.fixed, body.rtls.mini-navbar .footer.fixed {
            margin: 0 70px 0 0
        }

        body.body-small.mini-navbar .footer.fixed, body.rtls.mini-navbar.fixed-sidebar .footer.fixed {
            margin: 0
        }

        body.rtls.top-navigation .navbar-toggle {
            float: right;
            margin-left: 15px;
            margin-right: 15px
        }

        .body-small.rtls.top-navigation .navbar-header {
            float: none
        }

        body.rtls.top-navigation #page-wrapper {
            margin: 0
        }

        body.rtls.mini-navbar #page-wrapper {
            margin: 0 70px 0 0
        }

        body.rtls.mini-navbar.fixed-sidebar #page-wrapper {
            margin: 0
        }

        body.rtls.body-small.fixed-sidebar.mini-navbar #page-wrapper {
            margin: 0 220px 0 0
        }

        body.rtls.body-small.fixed-sidebar.mini-navbar .navbar-static-side {
            width: 220px
        }

        .body-small.rtls .navbar-fixed-top {
            margin-right: 0
        }

        .body-small.rtls .navbar-header {
            float: right
        }

        body.rtls .navbar-top-links li:last-child {
            margin-left: 20px
        }

        body.rtls .top-navigation #page-wrapper, body.rtls .top-navigation .footer.fixed, body.rtls.mini-navbar .top-navigation #page-wrapper, body.rtls.mini-navbar.top-navigation #page-wrapper, body.rtls.top-navigation .footer.fixed {
            margin: 0
        }

        @media (max-width: 768px) {
            body.rtls .navbar-top-links li:last-child {
                margin-left: 20px
            }

            .body-small.rtls #page-wrapper {
                position: inherit;
                margin: 0;
                min-height: 1000px
            }

            .body-small.rtls .navbar-static-side {
                display: none;
                z-index: 2001;
                position: absolute;
                width: 70px
            }

            .body-small.rtls.mini-navbar .navbar-static-side {
                display: block
            }

            .rtls.fixed-sidebar.body-small .navbar-static-side {
                display: none;
                z-index: 2001;
                position: fixed;
                width: 220px
            }

            .rtls.fixed-sidebar.body-small.mini-navbar .navbar-static-side {
                display: block
            }
        }

        .rtls .ltr-support {
            direction: ltr
        }

        .skin-setttings .title {
            background: #efefef;
            text-align: center;
            text-transform: uppercase;
            font-weight: 600;
            display: block;
            padding: 10px 15px;
            font-size: 12px
        }

        .setings-item {
            padding: 10px 30px
        }

        .setings-item.nb {
            border: none
        }

        .setings-item.skin {
            text-align: center
        }

        .setings-item .switch {
            float: right
        }

        .skin-name a {
            text-transform: uppercase
        }

        .setings-item a {
            color: #fff
        }

        .blue-skin, .default-skin, .ultra-skin, .yellow-skin {
            text-align: center
        }

        .default-skin {
            font-weight: 600;
            background: #1ab394
        }

        .default-skin:hover {
            background: #199d82
        }

        .blue-skin {
            font-weight: 600;
            background: url(patterns/header-profile-skin-1.png) repeat scroll 0 0
        }

        .blue-skin:hover {
            background: #0d8ddb
        }

        .yellow-skin {
            font-weight: 600;
            background: url(patterns/header-profile-skin-3.png) repeat scroll 0 100%
        }

        .yellow-skin:hover {
            background: #ce8735
        }

        .content-tabs {
            border-bottom: solid 2px #2f4050
        }

        .page-tabs a {
            color: #999
        }

        .page-tabs a i {
            color: #ccc
        }

        .page-tabs a.active {
            background: #2f4050;
            color: #a7b1c2
        }

        .page-tabs a.active i:hover, .page-tabs a.active:hover {
            background: #293846;
            color: #fff
        }

        .skin-1 .minimalize-styl-2 {
            margin: 14px 5px 5px 30px
        }

        .skin-1 .navbar-top-links li:last-child {
            margin-right: 30px
        }

        .skin-1.fixed-nav .minimalize-styl-2 {
            margin: 14px 5px 5px 15px
        }

        .skin-1 .spin-icon {
            background: #0e9aef !important
        }

        .skin-1 .nav-header {
            background: #0e9aef;
            background: url(patterns/header-profile-skin-1.png)
        }

        .skin-1.mini-navbar .nav-second-level {
            background: #3e495f
        }

        .skin-1 .breadcrumb {
            background: 0 0
        }

        .skin-1 .page-heading {
            border: none
        }

        .skin-1 .nav > li.active {
            background: #3a4459
        }

        .skin-1 .nav > li > a {
            color: #9ea6b9
        }

        .skin-1 .nav > li.active > a {
            color: #fff
        }

        .skin-1 .navbar-minimalize {
            background: #0e9aef;
            border-color: #0e9aef
        }

        body.skin-1 {
            background: #3e495f
        }

        .skin-1 .navbar-static-top {
            background: #fff
        }

        .skin-1 .dashboard-header {
            background: 0 0;
            border-bottom: none !important;
            border-top: none;
            padding: 20px 30px 10px
        }

        .fixed-nav.skin-1 .navbar-fixed-top {
            background: #fff
        }

        .skin-1 .wrapper-content {
            padding: 30px 15px
        }

        .skin-1 #page-wrapper {
            background: #f4f6fa
        }

        .skin-1 .ibox-content, .skin-1 .ibox-title {
            border-width: 1px
        }

        .skin-1 .ibox-content:last-child {
            border-style: solid
        }

        .skin-1 .nav > li.active {
            border: none
        }

        .skin-1 .nav-header {
            padding: 35px 25px 25px
        }

        .skin-1 .nav-header a.dropdown-toggle {
            color: #fff;
            margin-top: 10px
        }

        .skin-1 .nav-header a.dropdown-toggle .text-muted {
            color: #fff;
            opacity: .8
        }

        .skin-1 .profile-element {
            text-align: center
        }

        .skin-1 .img-circle {
            border-radius: 5px
        }

        .skin-1 .navbar-default .nav > li > a:focus, .skin-1 .navbar-default .nav > li > a:hover {
            background: #39aef5;
            color: #fff
        }

        .skin-1 .nav.nav-tabs > li.active > a {
            color: #555
        }

        .skin-1 .content-tabs {
            border-bottom: solid 2px #39aef5
        }

        .skin-1 .nav.nav-tabs > li.active {
            background: 0 0
        }

        .skin-1 .page-tabs a.active {
            background: #39aef5;
            color: #fff
        }

        .skin-1 .page-tabs a.active i:hover, .skin-1 .page-tabs a.active:hover {
            background: #0e9aef;
            color: #fff
        }

        .skin-3 .minimalize-styl-2 {
            margin: 14px 5px 5px 30px
        }

        .skin-3 .navbar-top-links li:last-child {
            margin-right: 30px
        }

        .skin-3.fixed-nav .minimalize-styl-2 {
            margin: 14px 5px 5px 15px
        }

        .skin-3 .spin-icon {
            background: #ecba52 !important
        }

        body.boxed-layout.skin-3 #wrapper {
            background: #3e2c42
        }

        .skin-3 .nav-header {
            background: #ecba52;
            background: url(patterns/header-profile-skin-3.png)
        }

        .skin-3.mini-navbar .nav-second-level {
            background: #3e2c42
        }

        .skin-3 .breadcrumb {
            background: 0 0
        }

        .skin-3 .page-heading {
            border: none
        }

        .skin-3 .nav > li.active {
            background: #38283c
        }

        .fixed-nav.skin-3 .navbar-fixed-top {
            background: #fff
        }

        .skin-3 .nav > li > a {
            color: #948b96
        }

        .skin-3 .nav > li.active > a {
            color: #fff
        }

        .skin-3 .navbar-minimalize {
            background: #ecba52;
            border-color: #ecba52
        }

        body.skin-3 {
            background: #3e2c42
        }

        .skin-3 .navbar-static-top {
            background: #fff
        }

        .skin-3 .dashboard-header {
            background: 0 0;
            border-bottom: none !important;
            border-top: none;
            padding: 20px 30px 10px
        }

        .skin-3 .wrapper-content {
            padding: 30px 15px
        }

        .skin-3 #page-wrapper {
            background: #f4f6fa
        }

        .skin-3 .ibox-content, .skin-3 .ibox-title {
            border-width: 1px
        }

        .skin-3 .ibox-content:last-child {
            border-style: solid
        }

        .skin-3 .nav > li.active {
            border: none
        }

        .skin-3 .nav-header {
            padding: 35px 25px 25px
        }

        .skin-3 .nav-header a.dropdown-toggle {
            color: #fff;
            margin-top: 10px
        }

        .skin-3 .nav-header a.dropdown-toggle .text-muted {
            color: #fff;
            opacity: .8
        }

        .skin-3 .profile-element {
            text-align: center
        }

        .skin-3 .img-circle {
            border-radius: 5px
        }

        .skin-3 .navbar-default .nav > li > a:focus, .skin-3 .navbar-default .nav > li > a:hover {
            background: #38283c;
            color: #fff
        }

        .skin-3 .nav.nav-tabs > li.active > a {
            color: #555
        }

        .skin-3 .content-tabs {
            border-bottom: solid 2px #3e2c42
        }

        .skin-3 .nav.nav-tabs > li.active {
            background: 0 0
        }

        .skin-3 .page-tabs a.active {
            background: #3e2c42;
            color: #fff
        }

        .skin-3 .page-tabs a.active i:hover, .skin-3 .page-tabs a.active:hover {
            background: #38283c;
            color: #fff
        }

        @media (min-width: 768px) {
            .navbar-top-links .dropdown-alerts, .navbar-top-links .dropdown-messages, .navbar-top-links .dropdown-tasks {
                margin-left: auto
            }
        }

        @media (max-width: 768px) {
            body.fixed-sidebar .navbar-static-side {
                display: none
            }

            body.fixed-sidebar.mini-navbar .navbar-static-side {
                width: 70px
            }

            .lock-word, .navbar-form-custom {
                display: none
            }

            .navbar-header {
                display: inline;
                float: left
            }

            .sidebard-panel {
                z-index: 2;
                position: relative;
                width: auto;
                min-height: 100% !important
            }

            .sidebar-content .wrapper {
                padding-right: 0;
                z-index: 1
            }

            .fixed-sidebar.body-small .navbar-static-side {
                display: none;
                z-index: 2001;
                position: fixed;
                width: 220px
            }

            .fixed-sidebar.body-small.mini-navbar .navbar-static-side {
                display: block
            }

            .ibox-tools {
                float: none;
                text-align: right;
                display: block
            }

            .content-tabs {
                display: none
            }

            #content-main {
                height: calc(100% - 100px)
            }

            .fixed-nav #content-main {
                height: calc(100% - 38px)
            }
        }

        .navbar-static-side {
            background: #2f4050
        }

        .nav-close {
            padding: 10px;
            position: absolute;
            right: 5px;
            top: 5px;
            font-size: 1.4em;
            cursor: pointer;
            z-index: 10;
            display: none;
            color: rgba(255, 255, 255, .3)
        }

        @media (max-width: 350px) {
            body.fixed-sidebar.mini-navbar .navbar-static-side {
                width: 0
            }

            .nav-close {
                display: block
            }

            #page-wrapper {
                margin-left: 0 !important
            }

            .timeline-item .date {
                text-align: left;
                width: 110px;
                position: relative;
                padding-top: 30px
            }

            .timeline-item .date i {
                position: absolute;
                top: 0;
                left: 15px;
                padding: 5px;
                width: 30px;
                text-align: center;
                border: 1px solid #e7eaec;
                background: #f8f8f8
            }

            .timeline-item .content {
                border-left: none;
                border-top: 1px solid #e7eaec;
                padding-top: 10px;
                min-height: 100px
            }

            .nav.navbar-top-links li.dropdown {
                display: none
            }

            .ibox-tools {
                float: none;
                text-align: left;
                display: inline-block
            }
        }

        .ui-jqgrid-titlebar {
            height: 40px;
            line-height: 24px;
            color: #676a6c;
            background-color: #F9F9F9;
            text-shadow: 0 1px 0 rgba(255, 255, 255, .5)
        }

        .ui-jqgrid .ui-jqgrid-title {
            float: left;
            margin-left: 5px;
            font-weight: 700
        }

        .ui-jqgrid .ui-jqgrid-titlebar {
            position: relative;
            border-left: 0 solid;
            border-right: 0 solid;
            border-top: 0 solid
        }

        .social-feed-separated .social-feed-box {
            margin-left: 62px
        }

        .social-feed-separated .social-avatar {
            float: left;
            padding: 0
        }

        .social-feed-separated .social-avatar img {
            width: 52px;
            height: 52px;
            border: 1px solid #e7eaec
        }

        .social-feed-separated .social-feed-box .social-avatar {
            padding: 15px 15px 0;
            float: none
        }

        .social-feed-box {
            border: 1px solid #e7eaec;
            background: #fff;
            margin-bottom: 15px
        }

        .article .social-feed-box {
            margin-bottom: 0;
            border-bottom: none
        }

        .article .social-feed-box:last-child {
            margin-bottom: 0;
            border-bottom: 1px solid #e7eaec
        }

        .article .social-feed-box p {
            font-size: 13px;
            line-height: 18px
        }

        .social-action {
            margin: 15px
        }

        .social-avatar {
            padding: 15px 15px 0
        }

        .social-comment .social-comment {
            margin-left: 45px
        }

        .social-avatar img {
            height: 40px;
            width: 40px;
            margin-right: 10px
        }

        .social-avatar .media-body a {
            font-size: 14px;
            display: block
        }

        .social-body {
            padding: 15px
        }

        .social-body img {
            margin-bottom: 10px
        }

        .social-footer {
            border-top: 1px solid #e7eaec;
            padding: 10px 15px;
            background: #f9f9f9
        }

        .social-footer .social-comment img {
            width: 32px;
            margin-right: 10px
        }

        .social-comment:first-child {
            margin-top: 0
        }

        .social-comment {
            margin-top: 15px
        }

        .social-comment textarea {
            font-size: 12px
        }

        .checkbox input[type=checkbox], .checkbox-inline input[type=checkbox], .radio input[type=radio], .radio-inline input[type=radio] {
            margin-top: -4px
        }

        @media (max-width: 1000px) {
            .welcome-message {
                display: none
            }
        }

        .echarts {
            height: 240px
        }

        .checkbox-inline, .checkbox-inline + .checkbox-inline, .radio-inline, .radio-inline + .radio-inline {
            margin: 0 15px 0 0
        }

        .navbar-toggle {
            background-color: #fff
        }

        .J_menuTab {
            -webkit-transition: all .3s ease-out 0s;
            transition: all .3s ease-out 0s
        }

        ::-webkit-scrollbar-track {
            background-color: #F5F5F5
        }

        ::-webkit-scrollbar {
            width: 6px;
            background-color: #F5F5F5
        }

        ::-webkit-scrollbar-thumb {
            background-color: #999
        }

        .gohome {
            position: fixed;
            top: 20px;
            right: 20px;
            z-index: 100
        }

        .gohome a {
            height: 38px;
            width: 38px;
            display: block;
            background: #2f4050;
            padding: 9px 8px;
            text-align: center;
            color: #fff;
            border-radius: 50%;
            opacity: .5
        }

        .gohome a:hover {
            opacity: 1
        }

        @media only screen and (-webkit-min-device-pixel-ratio: 2) {
            #content-main {
                -webkit-overflow-scrolling: touch;
            }
        }

        .navbar-header {
            width: 60%
        }

        .bs-glyphicons {
            margin: 0 -10px 20px;
            overflow: hidden
        }

        .bs-glyphicons-list {
            padding-left: 0;
            list-style: none
        }

        .bs-glyphicons li {
            float: left;
            width: 25%;
            height: 115px;
            padding: 10px;
            font-size: 10px;
            line-height: 1.4;
            text-align: center;
            background-color: #f9f9f9;
            border: 1px solid #fff
        }

        .bs-glyphicons .glyphicon {
            margin-top: 5px;
            margin-bottom: 10px;
            font-size: 24px
        }

        .bs-glyphicons .glyphicon-class {
            display: block;
            text-align: center;
            word-wrap: break-word
        }

        .bs-glyphicons li:hover {
            color: #fff;
            background-color: #1ab394
        }

        @media (min-width: 768px) {
            .bs-glyphicons {
                margin-right: 0;
                margin-left: 0
            }

            .bs-glyphicons li {
                width: 12.5%;
                font-size: 12px
            }
        }
    </style>
</head>
<body class="gray-bg">
<div class="row  border-bottom white-bg dashboard-header">
    <div class="col-sm-12 text-center">
        <span style="color: #1ab394; font-size: 20px; font-weight: 700">æµè¯æ¥å</span>
    </div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>æ¥åæ±æ»</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="col-sm-6 b-r" style="height:350px">
                            <form class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label text-navy">ç¨ä¾åç§°:</label>
                                    <div class="col-sm-5">
                                        <span class="form-control" id="testName"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label text-navy">ç¨ä¾æ»æ°:</label>
                                    <div class="col-sm-5">
                                        <span class="form-control" id="testAll"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label text-navy">ç¨ä¾éè¿:</label>
                                    <div class="col-sm-5">
                                        <span class="form-control" id="testPass"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label text-danger">ç¨ä¾å¤±è´¥:</label>
                                    <div class="col-sm-5">
                                        <span class="form-control text-danger" id="testFail"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label text-warning">ç¨ä¾è·³è¿:</label>
                                    <div class="col-sm-5">
                                        <span class="form-control text-warning" id="testSkip"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label text-navy">å¼å§æ¶é´:</label>
                                    <div class="col-sm-5">
                                        <span class="form-control" id="beginTime"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label text-navy">è¿è¡æ¶é´:</label>
                                    <div class="col-sm-5">
                                        <span class="form-control" id="totalTime"></span>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="col-sm-6">
                            <div style="height:350px" id="echarts-map-chart"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>è¯¦ç»æ°æ®</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <div class="input-group panel-heading" style="width: 100%; background-color: #1ab394; margin-bottom: 10px; text-align: left; font-family: Consolas;">
                        <label style="color: snow">æµè¯ç±»:</label>
                        <select class="chosen-select form-control" data-placeholder="----------" style="width: 300px;" name="filterClass" id="filterClass">
                            <option value="">----------</option>
                        </select>
                        <label style="color: snow">ç»æ:</label>
                        <select class="chosen-select form-control" data-placeholder="----------" style="width: 300px;" name="filterResult" id="filterResult">
                            <option value="">----------</option>
                        </select>
                        <div style="float: right">
                            <label class="form-control">
                                <span class="text-navy">ç¨ä¾æ°: </span><span class="text-navy b-r" id="filterAll"></span><span> | </span>
                                <span style="color: green">æå: </span><span style="color: green" id="filterOk"></span><span> | </span>
                                <span class="text-danger">å¤±è´¥: </span><span class="text-danger" id="filterFail"></span><span> | </span>
                                <span class="text-warning">è·³è¿: </span><span class="text-warning" id="filterSkip"></span>
                            </label>
                        </div>
                    </div>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>ç¼å·</th><th>æµè¯ç±»</th><th>æµè¯æ¹æ³</th><th>ç¨ä¾æè¿°</th><th>èæ¶</th><th>ç»æ</th><th>æä½</th>
                        </tr>
                        </thead>
                        <tbody id="detailBody">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="jquery/jquery.min.js"></script>
<script src="webjars/bootstrap/bootstrap.min.js"></script>
<script src="jquery/echarts.min.js"></script>
<script src="jquery/chosen.jquery.js"></script>
<script type="text/javascript">
	function $childNode(o) {
	    return window.frames[o]
	}
	function animationHover(o, e) {
	    o = $(o), o.hover(function () {
	        o.addClass("animated " + e)
	    }, function () {
	        window.setTimeout(function () {
	            o.removeClass("animated " + e)
	        }, 2e3)
	    })
	}
	function WinMove() {
	    var o = "[class*=col]", e = ".ibox-title", i = "[class*=col]";
	    $(o).sortable({
	        handle: e,
	        connectWith: i,
	        tolerance: "pointer",
	        forcePlaceholderSize: !0,
	        opacity: .8
	    }).disableSelection()
	}
	var $parentNode = window.parent.document;
	if ($(".tooltip-demo").tooltip({
	        selector: "[data-toggle=tooltip]",
	        container: "body"
	    }), $(".modal").appendTo("body"), $("[data-toggle=popover]").popover(), $(".collapse-link").click(function () {
	        var o = $(this).closest("div.ibox"), e = $(this).find("i"), i = o.find("div.ibox-content");
	        i.slideToggle(200), e.toggleClass("fa-chevron-up").toggleClass("fa-chevron-down"), o.toggleClass("").toggleClass("border-bottom"), setTimeout(function () {
	            o.resize(), o.find("[id^=map-]").resize()
	        }, 50)
	    }), $(".close-link").click(function () {
	        var o = $(this).closest("div.ibox");
	        o.remove()
	    }), top == this) {
	}
</script>
<script type="text/javascript">
    var resultData = {
    "testPass": 1,
    "testFail": 1,
    "testResult": [
        {
            "status": "å¤±è´¥",
            "log": [
                "",
                "Traceback (most recent call last):\n",
                "  File \"C:\\Python35\\lib\\unittest\\case.py\", line 58, in testPartExecutor\n    yield\n",
                "  File \"C:\\Python35\\lib\\unittest\\case.py\", line 597, in run\n    testMethod()\n",
                "  File \"E:\\hepeng2\\hepeng1\\TestCase\\1316\\test1.py\", line 15, in test_zhunru\n    self.assertEquals(1,2)\n",
                "  File \"C:\\Python35\\lib\\unittest\\case.py\", line 1305, in deprecated_func\n    return original_func(*args, **kwargs)\n",
                "  File \"C:\\Python35\\lib\\unittest\\case.py\", line 817, in assertEqual\n    assertion_func(first, second, msg=msg)\n",
                "  File \"C:\\Python35\\lib\\unittest\\case.py\", line 810, in _baseAssertEqual\n    raise self.failureException(msg)\n",
                "AssertionError: 1 != 2\n"
            ],
            "description": "\n        ææè´·botï¼åå¥æµè¯\n        æºæå·ï¼HCSH2026\n        2019071017420101\n        :return:\n        ",
            "className": "test_1316",
            "spendTime": "0.0 s",
            "methodName": "test_zhunru"
        },
        {
            "status": "æå",
            "log": [
                ""
            ],
            "description": "\n        æ²¡éç½®æºæéé¢\n        :return:\n        ",
            "className": "test_1316",
            "spendTime": "0.0 s",
            "methodName": "test_zhunru01"
        }
    ],
    "totalTime": "0s",
    "testName": "æµè¯",
    "testError": 0,
    "testAll": 2,
    "testSkip": 0,
    "beginTime": "2019-07-16 21:12:25"
};

    function clickRow(obj){
        $("#detailBody").children("tr").attr("style","font-family: Consolas");
        $(obj).attr("style","font-family: Consolas; background-color: #b0d877");
    }

    function details(obj) {
        if ($(obj).text() == 'å±å¼') {
            var len = $(obj).parent().parent().children().length;
            var detailLog = "";
            var logs = resultData["testResult"][parseInt($(obj).attr("buttonIndex"))]["log"];
            $(obj).text("æ¶ç¼©");
            $(obj).removeClass("btn-primary");
            $(obj).addClass("btn-danger");
            $.each(logs, function (i, n) {
                detailLog = detailLog + "<p>" + n + "</p>";
            });
            $(obj).parent().parent().after("<tr><td colspan='" + len + "'><div style='font-family: Consolas;font-size:12px'>" + detailLog + "</div></td></tr>");
        } else if ($(obj).text() == 'æ¶ç¼©') {
            $(obj).parent().parent().next().remove();
            $(obj).text("å±å¼");
            $(obj).removeClass("btn-danger");
            $(obj).addClass("btn-primary");
        }

    }
    $(function () {
        $("#testName").text(resultData["testName"]);
        $("#testPass").text(resultData["testPass"]);
        $("#testFail").text(resultData["testFail"]);
        $("#testSkip").text(resultData["testSkip"]);
        $("#testAll").text(resultData["testAll"]);
        $("#beginTime").text(resultData["beginTime"]);
        $("#totalTime").text(resultData["totalTime"]);
        $("#filterAll").text(resultData["testAll"]);
        $("#filterOk").text(resultData["testPass"]);
        $("#filterFail").text(resultData["testFail"]);
        $("#filterSkip").text(resultData["testSkip"]);
        var classNames = [];
        var results = [];
        $.each(resultData["testResult"], function (i, n) {
            if (classNames.indexOf(n["className"]) == -1) {
                classNames.push(n["className"]);
            }
            if (results.indexOf(n["status"]) == -1) {
                results.push(n["status"]);
            }
        });

        $.each(classNames, function (i, n) {
            $("#filterClass").append("<option value='" + n + "' hassubinfo='true'>" + n + "</option>");
        });
        $.each(results, function (i, n) {
            $("#filterResult").append("<option value='" + n + "' hassubinfo='true'>" + n + "</option>");
        });

        $("#filterClass").chosen({search_contains: true});
        $("#filterResult").chosen({search_contains: true});

        function generateResult(className, caseResult) {
            $("#detailBody").children().remove();
            var filterAll = 0;
            var filterOk = 0;
            var filterFail = 0;
            var filterSkip = 0;
            $.each(resultData["testResult"], function (i, n) {
                if ((className == "" || n["className"] == className) && (caseResult == "" || n["status"] == caseResult)) {
                    filterAll += 1;
                    var status = "";
                    if (n["status"] == 'æå') {
                        filterOk += 1;
                        status = "<td><span class='text-navy'>æå</span></td>";
                    } else if (n["status"] == 'å¤±è´¥') {
                        filterFail += 1;
                        status = "<td><span class='text-danger'>å¤±è´¥</span></td>";
                    } else if (n["status"] == 'è·³è¿') {
                        filterSkip += 1;
                        status = "<td><span class='text-warning'>è·³è¿</span></td>";
                    } else {
                        status = "<td><span>" + n["status"] + "</span></td>";
                    }
                    var tr = "<tr style='font-family: Consolas'>" +
                        "<td>" + (i + 1) + "</td>" +
                        "<td>" + n["className"] + "</td>" +
                        "<td>" + n["methodName"] + "</td>" +
                        "<td>" + n["description"] + "</td>" +
                        "<td>" + n["spendTime"] + "</td>" +
                        status + "<td><button type='button' onclick='details(this)' buttonIndex='" + i + "' class='btn btn-primary btn-xs' style='margin-bottom: 0px'>å±å¼</button></td></tr>"
                    $("#detailBody").append(tr);
                }
            });
            $("#filterAll").text(filterAll);
            $("#filterOk").text(filterOk);
            $("#filterFail").text(filterFail);
            $("#filterSkip").text(filterSkip);
        }

        generateResult("", "");

        $("#filterClass").on('change', function () {
            var className = $("#filterClass").val();
            var caseResult = $("#filterResult").val();
            generateResult(className, caseResult);
        });

        $("#filterResult").on('change', function () {
            var className = $("#filterClass").val();
            var caseResult = $("#filterResult").val();
            generateResult(className, caseResult);
        });

        //$(".chosen-select").trigger("chosen:updated");

        function pie() {
            var option = {
                title: {
                    text: 'æµè¯ç¨ä¾è¿è¡ç»æ',
                    subtext: '',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: ['å¤±è´¥', 'è·³è¿', 'æå']
                },
                series: [
                    {
                        name: 'è¿è¡ç»æ',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '60%'],
                        data: [
                            {value: resultData["testFail"], name: 'å¤±è´¥'},
                            {value: resultData["testSkip"], name: 'è·³è¿'},
                            {value: resultData["testPass"], name: 'æå'}
                        ],
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };
            var chart = echarts.init(document.getElementById("echarts-map-chart"));
            chart.setOption(option);
        }

        pie();
    });

</script>
</body>
</html>
