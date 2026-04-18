.class public Lorg/drinkless/tdlib/TdApi$AnswerCallbackQuery;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AnswerCallbackQuery"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x44b9d18a


# instance fields
.field public cacheTime:I

.field public callbackQueryId:J

.field public showAlert:Z

.field public text:Ljava/lang/String;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46604
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 46605
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;ZLjava/lang/String;I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "z8"    # Z
    .param p5, "str2"    # Ljava/lang/String;
    .param p6, "i9"    # I

    .line 46591
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 46592
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AnswerCallbackQuery;->callbackQueryId:J

    .line 46593
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AnswerCallbackQuery;->text:Ljava/lang/String;

    .line 46594
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$AnswerCallbackQuery;->showAlert:Z

    .line 46595
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$AnswerCallbackQuery;->url:Ljava/lang/String;

    .line 46596
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$AnswerCallbackQuery;->cacheTime:I

    .line 46597
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46601
    const v0, -0x44b9d18a

    return v0
.end method
