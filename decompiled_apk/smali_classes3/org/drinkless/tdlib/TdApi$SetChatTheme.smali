.class public Lorg/drinkless/tdlib/TdApi$SetChatTheme;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatTheme"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x57e78852


# instance fields
.field public chatId:J

.field public theme:Lorg/drinkless/tdlib/TdApi$InputChatTheme;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31448
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31449
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$InputChatTheme;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "inputChatTheme"    # Lorg/drinkless/tdlib/TdApi$InputChatTheme;

    .line 31438
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31439
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatTheme;->chatId:J

    .line 31440
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatTheme;->theme:Lorg/drinkless/tdlib/TdApi$InputChatTheme;

    .line 31441
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31445
    const v0, 0x57e78852

    return v0
.end method
