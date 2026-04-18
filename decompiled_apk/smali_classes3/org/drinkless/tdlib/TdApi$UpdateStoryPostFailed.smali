.class public Lorg/drinkless/tdlib/TdApi$UpdateStoryPostFailed;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateStoryPostFailed"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4a6589fc


# instance fields
.field public error:Lorg/drinkless/tdlib/TdApi$Error;

.field public errorType:Lorg/drinkless/tdlib/TdApi$CanPostStoryResult;

.field public story:Lorg/drinkless/tdlib/TdApi$Story;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41890
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41891
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Story;Lorg/drinkless/tdlib/TdApi$Error;Lorg/drinkless/tdlib/TdApi$CanPostStoryResult;)V
    .locals 0
    .param p1, "story"    # Lorg/drinkless/tdlib/TdApi$Story;
    .param p2, "error"    # Lorg/drinkless/tdlib/TdApi$Error;
    .param p3, "canPostStoryResult"    # Lorg/drinkless/tdlib/TdApi$CanPostStoryResult;

    .line 41879
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41880
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateStoryPostFailed;->story:Lorg/drinkless/tdlib/TdApi$Story;

    .line 41881
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateStoryPostFailed;->error:Lorg/drinkless/tdlib/TdApi$Error;

    .line 41882
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateStoryPostFailed;->errorType:Lorg/drinkless/tdlib/TdApi$CanPostStoryResult;

    .line 41883
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41887
    const v0, 0x4a6589fc    # 3760767.0f

    return v0
.end method
