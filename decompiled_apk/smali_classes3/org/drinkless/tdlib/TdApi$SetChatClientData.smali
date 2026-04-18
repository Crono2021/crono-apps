.class public Lorg/drinkless/tdlib/TdApi$SetChatClientData;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatClientData"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x314cd8c3


# instance fields
.field public chatId:J

.field public clientData:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31188
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31189
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 31178
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31179
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatClientData;->chatId:J

    .line 31180
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatClientData;->clientData:Ljava/lang/String;

    .line 31181
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31185
    const v0, -0x314cd8c3

    return v0
.end method
