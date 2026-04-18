.class public Lorg/drinkless/tdlib/TdApi$CheckChatUsername;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CheckChatUsername"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$CheckChatUsernameResult;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7199df0


# instance fields
.field public chatId:J

.field public username:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24544
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24545
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 24534
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24535
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CheckChatUsername;->chatId:J

    .line 24536
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$CheckChatUsername;->username:Ljava/lang/String;

    .line 24537
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24541
    const v0, -0x7199df0

    return v0
.end method
