.class public Lorg/drinkless/tdlib/TdApi$CallbackQueryAnswer;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CallbackQueryAnswer"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1582685d


# instance fields
.field public showAlert:Z

.field public text:Ljava/lang/String;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35948
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35949
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZLjava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z
    .param p3, "str2"    # Ljava/lang/String;

    .line 35937
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35938
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CallbackQueryAnswer;->text:Ljava/lang/String;

    .line 35939
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$CallbackQueryAnswer;->showAlert:Z

    .line 35940
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$CallbackQueryAnswer;->url:Ljava/lang/String;

    .line 35941
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35945
    const v0, 0x1582685d

    return v0
.end method
