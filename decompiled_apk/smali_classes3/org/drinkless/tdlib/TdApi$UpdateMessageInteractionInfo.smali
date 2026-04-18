.class public Lorg/drinkless/tdlib/TdApi$UpdateMessageInteractionInfo;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateMessageInteractionInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x547fc402


# instance fields
.field public chatId:J

.field public interactionInfo:Lorg/drinkless/tdlib/TdApi$MessageInteractionInfo;

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41736
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41737
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$MessageInteractionInfo;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "messageInteractionInfo"    # Lorg/drinkless/tdlib/TdApi$MessageInteractionInfo;

    .line 41725
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41726
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageInteractionInfo;->chatId:J

    .line 41727
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageInteractionInfo;->messageId:J

    .line 41728
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageInteractionInfo;->interactionInfo:Lorg/drinkless/tdlib/TdApi$MessageInteractionInfo;

    .line 41729
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41733
    const v0, -0x547fc402

    return v0
.end method
