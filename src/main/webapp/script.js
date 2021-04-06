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

async function getGuide() {
    const responseFromServer = await fetch('/guides');
    const jsonResponse = await responseFromServer.json();
    const guides_container = document.getElementById($('#product'));

    for (let i = 0; i < jsonResponse.length; i++) {
        $('#product').append(guidesToHTML(jsonResponse[i]));
    }
}

function guidesToHTML(guide) {
    let id = guide.id;
    let title = guide.title;
    let description = guide.description;
    let timestamp = guide.timestamp; // Returns in ms
    let date = new Date(timestamp); // Convert to date

    return `<div class="card w-75 itemBox item1">
        <div class="card-header">${id}</div>
        <div class="card-body">
            <h5 class="card-title">${title}</h5>
            <p class="card-text">${description}</p>
            <footer class="blockquote-footer">
                <small class="text-muted">
                Last updated <cite title="Source Title">${date.toDateString()}</cite>
                </small>
            </footer>
        </div>
    </div>`;
}
