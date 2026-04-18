.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewOptions;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewOptions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3e61b3f3


# instance fields
.field public forceLargeMedia:Z

.field public forceSmallMedia:Z

.field public isDisabled:Z

.field public showAboveText:Z

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47878
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 47879
    return-void
.end method

.method public constructor <init>(ZLjava/lang/String;ZZZ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "z9"    # Z
    .param p4, "z10"    # Z
    .param p5, "z11"    # Z

    .line 47865
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 47866
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewOptions;->isDisabled:Z

    .line 47867
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewOptions;->url:Ljava/lang/String;

    .line 47868
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewOptions;->forceSmallMedia:Z

    .line 47869
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewOptions;->forceLargeMedia:Z

    .line 47870
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewOptions;->showAboveText:Z

    .line 47871
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47875
    const v0, 0x3e61b3f3

    return v0
.end method
