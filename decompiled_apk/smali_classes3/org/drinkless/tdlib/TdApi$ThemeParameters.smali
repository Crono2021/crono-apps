.class public Lorg/drinkless/tdlib/TdApi$ThemeParameters;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ThemeParameters"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x107c6a51


# instance fields
.field public accentTextColor:I

.field public backgroundColor:I

.field public bottomBarBackgroundColor:I

.field public buttonColor:I

.field public buttonTextColor:I

.field public destructiveTextColor:I

.field public headerBackgroundColor:I

.field public hintColor:I

.field public linkColor:I

.field public secondaryBackgroundColor:I

.field public sectionBackgroundColor:I

.field public sectionHeaderTextColor:I

.field public sectionSeparatorColor:I

.field public subtitleTextColor:I

.field public textColor:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54604
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54605
    return-void
.end method

.method public constructor <init>(IIIIIIIIIIIIIII)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "i11"    # I
    .param p4, "i12"    # I
    .param p5, "i13"    # I
    .param p6, "i14"    # I
    .param p7, "i15"    # I
    .param p8, "i16"    # I
    .param p9, "i17"    # I
    .param p10, "i18"    # I
    .param p11, "i19"    # I
    .param p12, "i20"    # I
    .param p13, "i21"    # I
    .param p14, "i22"    # I
    .param p15, "i23"    # I

    .line 54581
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54582
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ThemeParameters;->backgroundColor:I

    .line 54583
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$ThemeParameters;->secondaryBackgroundColor:I

    .line 54584
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ThemeParameters;->headerBackgroundColor:I

    .line 54585
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$ThemeParameters;->bottomBarBackgroundColor:I

    .line 54586
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$ThemeParameters;->sectionBackgroundColor:I

    .line 54587
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$ThemeParameters;->sectionSeparatorColor:I

    .line 54588
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$ThemeParameters;->textColor:I

    .line 54589
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$ThemeParameters;->accentTextColor:I

    .line 54590
    iput p9, p0, Lorg/drinkless/tdlib/TdApi$ThemeParameters;->sectionHeaderTextColor:I

    .line 54591
    iput p10, p0, Lorg/drinkless/tdlib/TdApi$ThemeParameters;->subtitleTextColor:I

    .line 54592
    iput p11, p0, Lorg/drinkless/tdlib/TdApi$ThemeParameters;->destructiveTextColor:I

    .line 54593
    iput p12, p0, Lorg/drinkless/tdlib/TdApi$ThemeParameters;->hintColor:I

    .line 54594
    iput p13, p0, Lorg/drinkless/tdlib/TdApi$ThemeParameters;->linkColor:I

    .line 54595
    iput p14, p0, Lorg/drinkless/tdlib/TdApi$ThemeParameters;->buttonColor:I

    .line 54596
    iput p15, p0, Lorg/drinkless/tdlib/TdApi$ThemeParameters;->buttonTextColor:I

    .line 54597
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54601
    const v0, -0x107c6a51

    return v0
.end method
