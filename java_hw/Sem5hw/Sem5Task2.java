/*	609. Найти дубликат файла в системе
	Учитывая список путей информации о каталоге, включая путь к каталогу, и все файлы с содержимым 
	в этом каталоге, вернуть все дубликаты файлов в файловой системе с точки зрения их путей. 
	Вы можете вернуть ответ в любом порядке.

	Группа файлов-дубликатов состоит как минимум из двух файлов с одинаковым содержимым.

	Одна информационная строка каталога во входном списке имеет следующий формат:

	"root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
	Это означает, что в каталоге "root/d1/d2/.../dm" имеется n файлов (f1.txt, f2.txt ... fn.txt) 
	с содержимым (f1_content, f2_content ... fn_content) соответственно. Обратите внимание, что 
	n >= 1 и m >= 0. Если m = 0, это означает, что каталог является просто корневым каталогом.

	Результатом является список групп повторяющихся путей к файлам. Для каждой группы он содержит 
	все пути к файлам с одинаковым содержимым. Путь к файлу — это строка, имеющая следующий формат:
	"directory_path/file_name.txt"
	*/

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> contentToFilePaths = new HashMap<>();

        for (String path : paths) {
            String[] words = path.split(" ");
            String rootPath = words[0];
            for (int i = 1; i < words.length; ++i) {
                String fileAndContent = words[i];
                int l = fileAndContent.indexOf('(');
                int r = fileAndContent.indexOf(')');
                String file = fileAndContent.substring(0, l);
                String content = fileAndContent.substring(l + 1, r);
                String filePath = rootPath + '/' + file;
                contentToFilePaths.putIfAbsent(content, new ArrayList<>());
                contentToFilePaths.get(content).add(filePath);
            }
        }

        for (List<String> filePaths : contentToFilePaths.values()) {
            if (filePaths.size() > 1)
                ans.add(filePaths);
        }

        return ans;
    }
}