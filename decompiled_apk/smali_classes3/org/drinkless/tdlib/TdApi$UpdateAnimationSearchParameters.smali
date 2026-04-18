.class public Lorg/drinkless/tdlib/TdApi$UpdateAnimationSearchParameters;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateAnimationSearchParameters"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x443f0ea2


# instance fields
.field public emojis:[Ljava/lang/String;

.field public provider:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33748
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33749
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "strArr"    # [Ljava/lang/String;

    .line 33738
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33739
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateAnimationSearchParameters;->provider:Ljava/lang/String;

    .line 33740
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateAnimationSearchParameters;->emojis:[Ljava/lang/String;

    .line 33741
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33745
    const v0, -0x443f0ea2

    return v0
.end method
