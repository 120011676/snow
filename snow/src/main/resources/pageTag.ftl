<div class="pageTagCss" align="right" >
	<a href="#" onclick="pageTurning('${formId}','0','${selectId}')">首页</a>
	<a href="#" onclick="pageTurning('${formId}','<#if page.nowPage == 0>0<#else>${page.nowPage-1}</#if>','${selectId}')">上一页</a>
	<a href="#" onclick="pageTurning('${formId}','<#if page.nowPage == page.maxPage-1>${page.maxPage-1}<#else>${page.nowPage+1}</#if>','${selectId}')">下一页</a>
	<a href="#" onclick="pageTurning('${formId}',${page.maxPage-1},'${selectId}')">尾页</a>
	第 <#if page.nowPage == page.maxPage>${page.nowPage}<#else>${page.nowPage +1}</#if> / ${page.maxPage} 页 共 ${page.maxCount} 行
	&nbsp;
	每 
	<select id="${selectId}" name="onePageRows" onchange="pageTurning('${formId}','0','${selectId}')">
		<option value="10" <#if page.onePageRows == 10>selected="selected"</#if>>10</option>
		<option value="20" <#if page.onePageRows == 20>selected="selected"</#if>>20</option>
		<option value="50" <#if page.onePageRows == 50>selected="selected"</#if>>50</option>
		<option value="100" <#if page.onePageRows == 100>selected="selected"</#if>>100</option>
	</select>
	&nbsp;
	条/页
</div>