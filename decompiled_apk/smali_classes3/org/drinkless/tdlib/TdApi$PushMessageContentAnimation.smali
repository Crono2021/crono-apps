.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentAnimation;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentAnimation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3da4dfe4


# instance fields
.field public animation:Lorg/drinkless/tdlib/TdApi$Animation;

.field public caption:Ljava/lang/String;

.field public isPinned:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39162
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 39163
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Animation;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "animation"    # Lorg/drinkless/tdlib/TdApi$Animation;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "z8"    # Z

    .line 39151
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 39152
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentAnimation;->animation:Lorg/drinkless/tdlib/TdApi$Animation;

    .line 39153
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentAnimation;->caption:Ljava/lang/String;

    .line 39154
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentAnimation;->isPinned:Z

    .line 39155
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39159
    const v0, 0x3da4dfe4

    return v0
.end method
