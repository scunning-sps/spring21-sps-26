// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

$(document).ready(function () {
    $('.list').click(function () {
        const value = $(this).attr('data-filter');
        if (value == 'all') {
            $('.itemBox').show('1000');
        }
        else {
            $('.itemBox').not('.' + value).hide('1000');
            $('.itemBox').filter('.' + value).show('1000');
        }
    })

    $('.list').click(function () {
        $(this).addClass('active').siblings().removeClass('active');
    })
})

function auto_grow(element) {
    element.style.height = "5px";
    element.style.height = (element.scrollHeight)+"px";
}

function submitAlert() {
  alert("Your form has been submited!");
}

async function getGuide() {
    const responseFromServer = await fetch('/guides');
    const jsonResponse = await responseFromServer.json();
    const guides_container = document.getElementById($('#product'));

    for (let i = 0; i < jsonResponse.length; i++) {
        $('#product').append(guidesToHTML(jsonResponse[i]));
    }
}

function guidesToHTML(guide) {
    return `<div id="guide-${guide.id}" class="card w-75 itemBox ${guide.category}">
        <div class="card-header">${guide.id}</div>
        <div class="card-body">
            <div class="row">
                <div class="col-10">
                    <h5 class="card-title">${guide.title}</h5>
                    <p class="card-text">${guide.description}</p>
                    <footer class="blockquote-footer">
                        <small class="text-muted">
                        Last updated <cite title="Source Title">${new Date(guide.timestamp).toDateString()}</cite>
                        </small>
                    </footer>
                </div>
                <div class="col-2 d-flex justify-content-end align-items-start">
                    <button class="btn btn-danger" onclick="confirmDelete(${ guide.id })">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
                            <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
                        </svg>
                    </button>
                </div>
            </div>
        </div>
    </div>`;
}
