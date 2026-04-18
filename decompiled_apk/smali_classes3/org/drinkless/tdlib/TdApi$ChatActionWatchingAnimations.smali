.class public Lorg/drinkless/tdlib/TdApi$ChatActionWatchingAnimations;
.super Lorg/drinkless/tdlib/TdApi$ChatAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatActionWatchingAnimations"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7a5e26b1


# instance fields
.field public emoji:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9690
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatAction;-><init>()V

    .line 9691
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 9681
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatAction;-><init>()V

    .line 9682
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatActionWatchingAnimations;->emoji:Ljava/lang/String;

    .line 9683
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9687
    const v0, 0x7a5e26b1

    return v0
.end method
