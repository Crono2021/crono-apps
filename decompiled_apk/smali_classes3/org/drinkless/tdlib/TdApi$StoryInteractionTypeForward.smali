.class public Lorg/drinkless/tdlib/TdApi$StoryInteractionTypeForward;
.super Lorg/drinkless/tdlib/TdApi$StoryInteractionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryInteractionTypeForward"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x27d23cff


# instance fields
.field public message:Lorg/drinkless/tdlib/TdApi$Message;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20436
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryInteractionType;-><init>()V

    .line 20437
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Message;)V
    .locals 0
    .param p1, "message"    # Lorg/drinkless/tdlib/TdApi$Message;

    .line 20427
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryInteractionType;-><init>()V

    .line 20428
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoryInteractionTypeForward;->message:Lorg/drinkless/tdlib/TdApi$Message;

    .line 20429
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20433
    const v0, 0x27d23cff

    return v0
.end method
