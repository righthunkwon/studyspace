<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://cdn.ckeditor.com/ckeditor5/36.0.1/super-build/ckeditor.js"></script>
<style>
	#dataEdit li {
		padding:10px 0px;
	}
	#subject {
		width:100%;
	}
	.ck-editor__editable[role="textbox"] {
		min-height: 300px;
	}
     .ck-content .image {
     	max-width: 100%;
		margin: 20px auto;
	}
</style>
<script>
	// ClassicEditor를 JQuery에 담아 실행 순서를 조정
	$(function() {
		CKEDITOR.ClassicEditor.create(document.getElementById("content"), {
            // https://ckeditor.com/docs/ckeditor5/latest/features/toolbar/toolbar.html#extended-toolbar-configuration-format
            toolbar: {
                items: [
                    'exportPDF','exportWord', '|',
                    'findAndReplace', 'selectAll', '|',
                    'heading', '|',
                    'bold', 'italic', 'strikethrough', 'underline', 'code', 'subscript', 'superscript', 'removeFormat', '|',
                    'bulletedList', 'numberedList', 'todoList', '|',
                    'outdent', 'indent', '|',
                    'undo', 'redo',
                    '-',
                    'fontSize', 'fontFamily', 'fontColor', 'fontBackgroundColor', 'highlight', '|',
                    'alignment', '|',
                    'link', 'insertImage', 'blockQuote', 'insertTable', 'mediaEmbed', 'codeBlock', 'htmlEmbed', '|',
                    'specialCharacters', 'horizontalLine', 'pageBreak', '|',
                    'textPartLanguage', '|',
                    'sourceEditing'
                ],
                shouldNotGroupWhenFull: true
            },
            // Changing the language of the interface requires loading the language file using the <script> tag.
            // language: 'es',
            list: {
                properties: {
                    styles: true,
                    startIndex: true,
                    reversed: true
                }
            },
            // https://ckeditor.com/docs/ckeditor5/latest/features/headings.html#configuration
            heading: {
                options: [
                    { model: 'paragraph', title: 'Paragraph', class: 'ck-heading_paragraph' },
                    { model: 'heading1', view: 'h1', title: 'Heading 1', class: 'ck-heading_heading1' },
                    { model: 'heading2', view: 'h2', title: 'Heading 2', class: 'ck-heading_heading2' },
                    { model: 'heading3', view: 'h3', title: 'Heading 3', class: 'ck-heading_heading3' },
                    { model: 'heading4', view: 'h4', title: 'Heading 4', class: 'ck-heading_heading4' },
                    { model: 'heading5', view: 'h5', title: 'Heading 5', class: 'ck-heading_heading5' },
                    { model: 'heading6', view: 'h6', title: 'Heading 6', class: 'ck-heading_heading6' }
                ]
            },
            // https://ckeditor.com/docs/ckeditor5/latest/features/editor-placeholder.html#using-the-editor-configuration
            placeholder: '',
            // https://ckeditor.com/docs/ckeditor5/latest/features/font.html#configuring-the-font-family-feature
            fontFamily: {
                options: [
                    'default',
                    'Arial, Helvetica, sans-serif',
                    'Courier New, Courier, monospace',
                    'Georgia, serif',
                    'Lucida Sans Unicode, Lucida Grande, sans-serif',
                    'Tahoma, Geneva, sans-serif',
                    'Times New Roman, Times, serif',
                    'Trebuchet MS, Helvetica, sans-serif',
                    'Verdana, Geneva, sans-serif'
                ],
                supportAllValues: true
            },
            // https://ckeditor.com/docs/ckeditor5/latest/features/font.html#configuring-the-font-size-feature
            fontSize: {
                options: [ 10, 12, 14, 'default', 18, 20, 22 ],
                supportAllValues: true
            },
            // Be careful with the setting below. It instructs CKEditor to accept ALL HTML markup.
            // https://ckeditor.com/docs/ckeditor5/latest/features/general-html-support.html#enabling-all-html-features
            htmlSupport: {
                allow: [
                    {
                        name: /.*/,
                        attributes: true,
                        classes: true,
                        styles: true
                    }
                ]
            },
            // Be careful with enabling previews
            // https://ckeditor.com/docs/ckeditor5/latest/features/html-embed.html#content-previews
            htmlEmbed: {
                showPreviews: true
            },
            // https://ckeditor.com/docs/ckeditor5/latest/features/link.html#custom-link-attributes-decorators
            link: {
                decorators: {
                    addTargetToExternalLinks: true,
                    defaultProtocol: 'https://',
                    toggleDownloadable: {
                        mode: 'manual',
                        label: 'Downloadable',
                        attributes: {
                            download: 'file'
                        }
                    }
                }
            },
            // https://ckeditor.com/docs/ckeditor5/latest/features/mentions.html#configuration
            mention: {
                feeds: [
                    {
                        marker: '@',
                        feed: [
                            '@apple', '@bears', '@brownie', '@cake', '@cake', '@candy', '@canes', '@chocolate', '@cookie', '@cotton', '@cream',
                            '@cupcake', '@danish', '@donut', '@dragée', '@fruitcake', '@gingerbread', '@gummi', '@ice', '@jelly-o',
                            '@liquorice', '@macaroon', '@marzipan', '@oat', '@pie', '@plum', '@pudding', '@sesame', '@snaps', '@soufflé',
                            '@sugar', '@sweet', '@topping', '@wafer'
                        ],
                        minimumCharacters: 1
                    }
                ]
            },
            // The "super-build" contains more premium features that require additional configuration, disable them below.
            // Do not turn them on unless you read the documentation and know how to configure them and setup the editor.
            removePlugins: [
                // These two are commercial, but you can try them out without registering to a trial.
                // 'ExportPdf',
                // 'ExportWord',
                'CKBox',
                'CKFinder',
                'EasyImage',
                // This sample uses the Base64UploadAdapter to handle image uploads as it requires no configuration.
                // https://ckeditor.com/docs/ckeditor5/latest/features/images/image-upload/base64-upload-adapter.html
                // Storing images as Base64 is usually a very bad idea.
                // Replace it on production website with other solutions:
                // https://ckeditor.com/docs/ckeditor5/latest/features/images/image-upload/image-upload.html
                // 'Base64UploadAdapter',
                'RealTimeCollaborativeComments',
                'RealTimeCollaborativeTrackChanges',
                'RealTimeCollaborativeRevisionHistory',
                'PresenceList',
                'Comments',
                'TrackChanges',
                'TrackChangesData',
                'RevisionHistory',
                'Pagination',
                'WProofreader',
                // Careful, with the Mathtype plugin CKEditor will not load when loading this sample
                // from a local file system (file://) - load this site via HTTP server if you enable MathType
                'MathType'
            ]
        });
		
		// 기존 업로드 파일 갯수 파악, 삭제파일이 있을 때 감소, 새로 업로드한 파일수 추가 할 때 사용하는 변수
		var fileCount = ${fileCount};
		
		// 폼 유효성 검사
		$("#dataEdit").submit(function() {
			if($("#subject").val()=="") {
				alert("제목을 입력하세요.");
				return false;
			}
			// 첨부파일이 1개 이상 있는지 체크
			// var fileCount = 0;
			$("input[type=file]").each(function(){
				if($(this).val() != "") fileCount++;
			});
			if(fileCount<1) {
				alert("첨부파일을 하나 이상 선택해주세요.");
				return false;
			}
			return true;
		});
		
		// 첨부파일 추가하기
		$(document).on('click', "#dataEdit input[value=' + ']", function() {
			$(this).parent().parent().append('<div><input type="file" name="filename"/><input type="button" value=" + "/></div>');
			// 이벤트가 발생한 +를 -로 value값을 변경한다.
			$(this).val(" - ");
		});
		
		// 첨부파일 제거하기
		$(document).on('click', "#dataEdit input[value=' - ']", function() {
			$(this).parent().remove();
		});
		
		// 기존 첨부파일 중 삭제파일 설정하기
		$("#fileList b").click(function() {
			// input에 name값을 delfile로 설정
			$(this).parent().next().attr("name", "delfile");
			// 보이는 파일명 삭제
			$(this).parent().remove();
			fileCount--;
		});
    });
</script>
<div class="container">
	<h1>자료실 글수정 폼</h1>
	<!-- 파일업로드 시 form 태그에 enctype을 표기하여야 한다. -->
	<form method="post" action="/campus/data/dataEditOk" id="dataEdit" enctype="multipart/form-data">
		<!-- 원글 글번호 -->
		<input type="hidden" name="no" value="${dto.no }"/>
		<ul>
			<li>제목</li>
			<li><input type="text" name="subject" id="subject" value="${dto.subject }"/></li>
			<li>글내용</li>
			<li>
				<!-- 에디터 -->
				<textarea name="content" id="content">${dto.content }</textarea>
			</li>
			<li>첨부파일</li>
			<li id="fileList">
				<!-- 기존에 업로드한 파일 -->
				<c:forEach var="fDTO" items="${fileList }">
					<div>${fDTO.filename } <b>X</b></div>
					<!-- 삭제파일명 설정 : 파일삭제시 name 속성값을 지정하여 삭제된 파일명이 서버로 보내지도록 설정한다. -->
					<input type="hidden" name="" value="${fDTO.filename }"/>
				</c:forEach>
				<div><input type="file" name="filename"/><input type="button" value=" + "/></div>
			<li>
				<input type="submit" value="자료실 수정하기"/>
			</li>
		</ul>
	</form>
</div>