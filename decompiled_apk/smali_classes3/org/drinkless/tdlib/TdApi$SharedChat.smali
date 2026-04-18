.class public Lorg/drinkless/tdlib/TdApi$SharedChat;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SharedChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4a87b01a


# instance fields
.field public chatId:J

.field public photo:Lorg/drinkless/tdlib/TdApi$Photo;

.field public title:Ljava/lang/String;

.field public username:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45318
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45319
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Photo;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;
    .param p5, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;

    .line 45306
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45307
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SharedChat;->chatId:J

    .line 45308
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SharedChat;->title:Ljava/lang/String;

    .line 45309
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SharedChat;->username:Ljava/lang/String;

    .line 45310
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$SharedChat;->photo:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 45311
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45315
    const v0, 0x4a87b01a    # 4446221.0f

    return v0
.end method
