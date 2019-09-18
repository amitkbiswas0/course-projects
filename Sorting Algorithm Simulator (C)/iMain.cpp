#include "iGraphics.h"
#include <iostream>
#include <string>
#include <cstring>

using namespace std;

//for changing screen
int start = 0;
bool menu = true;

//global arrays and variables
int arr[201];
int N;
int main_arr_cpy[201];
int main_arr_cpy_ref[201];
char main_arr_cpy_ref_char[201][10];
string main_arr_cpy_ref_string[201];

int arrS = 0;
int indec = 0;

int arr_steps[1001][201];
int main_arr_cpySteps[201];

int help_mat[10][201];
int help_mat_ref[10][201];
bool sim = false;
int iC = 0, jC = 0, mC = 0;

//for changing instructions
bool instruc1 = false , instruc2=false;
bool clean_slate = false;

//for block position and setup
struct blockStyle{

	int xBlock;
	int yBlock;
	int r;
	int g;
	int b;
};
blockStyle blocks[201];
bool drawBlocks = false;

//function calls
void build();
void bubbleSort();
void insertionSort();
void intro();
void change();
void clean();

void iDraw()
{
	iClear();

	if (!drawBlocks){

		if (start == 0){
			iShowBMP(0, 0, "images/start.bmp");
		}
		else if (start == 1){
			iShowBMP(0, 0, "images/about.bmp");
			iShowBMP2(5, 521, "images/backButton.bmp", 0);
		}
		else if (start == 2){
			iShowBMP(0, 0, "images/instruc.bmp");
			iShowBMP2(5, 521, "images/backButton.bmp", 0);
		}
		else if (start == 3){
			iShowBMP(0, 0, "images/sortingSelection.bmp");
			iShowBMP2(5, 521, "images/backbutton.bmp", 0);
		}
	}
	else {

		iSetColor(255, 255, 255);
		iFilledRectangle(0, 0, 1024, 576);
		iSetColor(0, 0, 0);
		iFilledRectangle(0, 0, 1024, 50);
		iShowBMP2(5, 521, "images/backbutton.bmp", 0);
		for (int i = 0; i < N; i++){
			iSetColor(blocks[i].r, blocks[i].g, blocks[i].b);
			iFilledRectangle(blocks[i].xBlock, blocks[i].yBlock, 50, main_arr_cpy_ref[i]*10);
			iSetColor(0, 0, 0);
			iText(blocks[i].xBlock + 5, blocks[i].yBlock + 5, main_arr_cpy_ref_char[i], GLUT_BITMAP_HELVETICA_18);
		}
		if (instruc1){
			iSetColor(255, 0, 0);
			iText(400, 500, "Press Right to Start !", GLUT_BITMAP_TIMES_ROMAN_24);
		}
		if (instruc2){
			instruc1 = false;
			iSetColor(0, 0, 0);
			iFilledRectangle(800, 500, 180, 50);
			iSetColor(255, 255, 255);
			iText(820, 520, "See console !", GLUT_BITMAP_TIMES_ROMAN_24);
			
		}
	}

}

void iMouseMove(int mx, int my)
{
	//place your codes here
}

void iMouse(int button, int state, int mx, int my)
{
	if (button == GLUT_LEFT_BUTTON && state == GLUT_DOWN)
	{
		//cout << mx << " " << my << endl;
		if (menu){

			if (mx >= 80 && mx <= 350 && my >= 105 && my <= 200){
				start = 1;
				menu = false;
			}//about
			if (mx >= 80 && mx <= 350 && my >= 240 && my <= 340){
				start = 2;
				menu = false;
			}//Instruction
			if (mx >= 80 && mx <= 350 && my >= 380 && my <= 475){
				start = 3;
				menu = false;
			}//tryIt
		}
		else {

			if (mx >= 5 && mx <= 55 && my >= 521 && my <= 571){
				start = 0;
				menu = true;
				drawBlocks = false;
				clean_slate = true;
			}//backbutton
		}
	}
}


void iKeyboard(unsigned char key)
{
	if (key == 'b' || key == 'i')
	{
		
		
		
	}
	if (key == 'b'){
		intro();
		bubbleSort();
	}
	if (key == 'i'){
		intro();
		insertionSort();
	}
}

void intro()
{
	cout << "*****************************************************************\n";
	cout << "*****************************************************************\n";
	cout << "*************		Due to the size limitation	*********\n";
	cout << "*************		Do not enter array with		*********\n";
	cout << "*************		Length More than 15 !		*********\n";
	cout << "*****************************************************************\n";
	cout << "*****************************************************************\n";
	cout << "\n\nEnter array length : ";
	cin >> N;
	cout << "Enter an array to be sorted : \n";
	for (int i = 0; i < N; i++){
		cin >> arr[i];
		main_arr_cpy[i] = arr[i];
		main_arr_cpy_ref[i] = arr[i];
		main_arr_cpy_ref_string[i] = to_string(arr[i]);
		strcpy_s(main_arr_cpy_ref_char[i], main_arr_cpy_ref_string[i].c_str());
	}
	cout << "\n\n\n";
	instruc1 = true;
	build();
}

/*
function iSpecialKeyboard() is called whenver user hits special keys like-
function keys, home, end, pg up, pg down, arraows etc. you have to use
appropriate constants to detect them. A list is:
GLUT_KEY_F1, GLUT_KEY_F2, GLUT_KEY_F3, GLUT_KEY_F4, GLUT_KEY_F5, GLUT_KEY_F6,
GLUT_KEY_F7, GLUT_KEY_F8, GLUT_KEY_F9, GLUT_KEY_F10, GLUT_KEY_F11, GLUT_KEY_F12,
GLUT_KEY_LEFT, GLUT_KEY_UP, GLUT_KEY_RIGHT, GLUT_KEY_DOWN, GLUT_KEY_PAGE UP,
GLUT_KEY_PAGE DOWN, GLUT_KEY_HOME, GLUT_KEY_END, GLUT_KEY_INSERT
*/
void iSpecialKeyboard(unsigned char key)
{

	if (key == GLUT_KEY_RIGHT)
	{
		sim = true;
		instruc2 = true;
		
	}
}


void build()
{
	int xlen = 150;
	for (int i = 0; i < N; i++){

		if (i == 0){
			blocks[i].xBlock = 100;
			blocks[i].yBlock = 50;
			blocks[i].r = rand() % 255;
			blocks[i].g = rand() % 255;
			blocks[i].b = rand() % 255;
		}
		else {
			blocks[i].xBlock = xlen;
			blocks[i].yBlock = 50;
			blocks[i].r = rand() % 255;
			blocks[i].g = rand() % 255;
			blocks[i].b = rand() % 255;
			xlen += 50;
		}
	}
	drawBlocks = true;
}

void bubbleSort()
{
	for (int i = 0; i < N - 1; i++){
		for (int j = 0; j < N - i - 1; j++){
			if (arr[j] > arr[j + 1]){
				swap(arr[j], arr[j + 1]);
			}
			for (int d = 0; d < N; d++){
				arr_steps[arrS][d] = arr[d];
			}
			arrS++;
		}
		/*for (int j = 0; j < N; j++){
			arr_steps[arrS][j] = arr[j];
		}
		arrS++;
		*/
	}
	/*for (int i = 0; i < arrS; i++){
		for (int j = 0; j < N; j++){
			cout << arr_steps[i][j] << " ";
		}
		cout << "\n";
	}*/

	for (int a = 0; a < N; a++){
		for (int b = 0; b < N; b++){
			help_mat[a][b] = blocks[b].xBlock;
			help_mat_ref[a][b] = help_mat[a][b];
		}
	}
}

void insertionSort()
{
	int key, j, i;
	for (i = 1; i < N; i++)
	{
		key = arr[i];
		j = i - 1;
		while (j >= 0 && arr[j] > key){
			arr[j + 1] = arr[j];
			j = j - 1;
		}
		arr[j + 1] = key;
		for (int d = 0; d < N; d++){
			arr_steps[arrS][d] = arr[d];
		}
		arrS++;
	}

	for (int a = 0; a < N; a++){
		for (int b = 0; b < N; b++){
			help_mat[a][b] = blocks[b].xBlock;
			help_mat_ref[a][b] = help_mat[a][b];
		}
	}
}


void change()
{
	if (clean_slate){

		clean();
	}
	if (sim)
	{
		if (iC == N){
			for (int a = 0; a < N; a++){
				for (int b = 0; b < N; b++){
					help_mat[a][b] = help_mat_ref[a][b];
				}
			}
			for (int c = 0; c < N; c++){
				main_arr_cpy[c] = arr_steps[mC][c];
			}
			iC = 0;
			jC = 0;
			mC++;

			cout << "Step " << mC << " done !\n";
			cout << "Previous Phase : ";
			for (int b = 0; b < N; b++){
				if (mC == 1){
					cout << main_arr_cpy_ref[b] << " ";
				}
				else {
					cout << arr_steps[mC-2][b] << " ";
				}
			}
			cout << "\nCurrent Phase : ";
			for (int a = 0; a < N; a++){
				cout << arr_steps[mC-1][a] << " ";
			}
			cout << "\n\n\n";
		}

		else {

			if (jC < N){

				if (main_arr_cpy[iC] == arr_steps[mC][jC]){

					for (int i = 0; i < N; i++){
						if (main_arr_cpy_ref[i] == main_arr_cpy[iC]){
							indec = i;
						}
					}
					if ((help_mat[iC][jC]) < (iC * 50 + 100)){
						help_mat[iC][jC] += 5;
						blocks[indec].xBlock -= 5;
					}
					else if ((help_mat[iC][jC]) > (iC * 50 + 100)){
						help_mat[iC][jC] -= 5;
						blocks[indec].xBlock += 5;
					}
					else if ((help_mat[iC][jC]) == (iC * 50 + 100)){
						iC++;
						jC = 0;
					}
				}
				else {
					jC++;
				}
			}
		}
	}
}

void clean()
{
	for (int i = 0; i < N; i++){
		for (int j = 0; j < N; j++){
			arr_steps[i][j] = 0;
			help_mat[i][j] = 0;
			help_mat_ref[i][j] = 0;
		}
		arr[i] = 0;
	}
	iC = 0;
	jC = 0;
	mC = 0;
	arrS = 0;
	indec = 0;
	sim = false;
	clean_slate = false;

}

int main()
{
	iSetTimer(50 , change);
	iInitialize(1024, 576, "Algorithm Simulator");
	return 0;
}