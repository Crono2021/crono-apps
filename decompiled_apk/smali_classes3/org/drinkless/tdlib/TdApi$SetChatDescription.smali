.class public Lorg/drinkless/tdlib/TdApi$SetChatDescription;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatDescription"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x74a8b45d


# instance fields
.field public chatId:J

.field public description:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31208
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31209
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 31198
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31199
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatDescription;->chatId:J

    .line 31200
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatDescription;->description:Ljava/lang/String;

    .line 31201
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31205
    const v0, 0x74a8b45d

    return v0
.end method
