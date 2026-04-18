.class public Lorg/drinkless/tdlib/TdApi$ToggleBusinessConnectedBotChatIsPaused;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleBusinessConnectedBotChatIsPaused"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4f364845


# instance fields
.field public chatId:J

.field public isPaused:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33048
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33049
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 33038
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33039
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleBusinessConnectedBotChatIsPaused;->chatId:J

    .line 33040
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleBusinessConnectedBotChatIsPaused;->isPaused:Z

    .line 33041
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33045
    const v0, 0x4f364845

    return v0
.end method
