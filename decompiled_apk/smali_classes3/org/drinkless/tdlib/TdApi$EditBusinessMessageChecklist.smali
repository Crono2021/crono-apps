.class public Lorg/drinkless/tdlib/TdApi$EditBusinessMessageChecklist;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditBusinessMessageChecklist"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BusinessMessage;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1a865f90


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public chatId:J

.field public checklist:Lorg/drinkless/tdlib/TdApi$InputChecklist;

.field public messageId:J

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47046
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47047
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJLorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$InputChecklist;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p7, "inputChecklist"    # Lorg/drinkless/tdlib/TdApi$InputChecklist;

    .line 47033
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47034
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageChecklist;->businessConnectionId:Ljava/lang/String;

    .line 47035
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageChecklist;->chatId:J

    .line 47036
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageChecklist;->messageId:J

    .line 47037
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageChecklist;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 47038
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageChecklist;->checklist:Lorg/drinkless/tdlib/TdApi$InputChecklist;

    .line 47039
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47043
    const v0, -0x1a865f90

    return v0
.end method
