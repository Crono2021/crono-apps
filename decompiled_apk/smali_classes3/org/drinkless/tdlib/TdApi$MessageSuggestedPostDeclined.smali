.class public Lorg/drinkless/tdlib/TdApi$MessageSuggestedPostDeclined;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageSuggestedPostDeclined"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x19b323b


# instance fields
.field public comment:Ljava/lang/String;

.field public suggestedPostMessageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28684
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28685
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 28674
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28675
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageSuggestedPostDeclined;->suggestedPostMessageId:J

    .line 28676
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$MessageSuggestedPostDeclined;->comment:Ljava/lang/String;

    .line 28677
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28681
    const v0, -0x19b323b

    return v0
.end method
