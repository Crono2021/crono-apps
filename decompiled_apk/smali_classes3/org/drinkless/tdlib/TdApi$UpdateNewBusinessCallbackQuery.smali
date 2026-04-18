.class public Lorg/drinkless/tdlib/TdApi$UpdateNewBusinessCallbackQuery;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateNewBusinessCallbackQuery"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x14125364


# instance fields
.field public chatInstance:J

.field public connectionId:Ljava/lang/String;

.field public id:J

.field public message:Lorg/drinkless/tdlib/TdApi$BusinessMessage;

.field public payload:Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;

.field public senderUserId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50934
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 50935
    return-void
.end method

.method public constructor <init>(JJLjava/lang/String;Lorg/drinkless/tdlib/TdApi$BusinessMessage;JLorg/drinkless/tdlib/TdApi$CallbackQueryPayload;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "str"    # Ljava/lang/String;
    .param p6, "businessMessage"    # Lorg/drinkless/tdlib/TdApi$BusinessMessage;
    .param p7, "j10"    # J
    .param p9, "callbackQueryPayload"    # Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;

    .line 50920
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 50921
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewBusinessCallbackQuery;->id:J

    .line 50922
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewBusinessCallbackQuery;->senderUserId:J

    .line 50923
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewBusinessCallbackQuery;->connectionId:Ljava/lang/String;

    .line 50924
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewBusinessCallbackQuery;->message:Lorg/drinkless/tdlib/TdApi$BusinessMessage;

    .line 50925
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewBusinessCallbackQuery;->chatInstance:J

    .line 50926
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewBusinessCallbackQuery;->payload:Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;

    .line 50927
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50931
    const v0, 0x14125364

    return v0
.end method
