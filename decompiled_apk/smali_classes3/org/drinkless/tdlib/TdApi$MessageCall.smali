.class public Lorg/drinkless/tdlib/TdApi$MessageCall;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageCall"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x201ede00


# instance fields
.field public discardReason:Lorg/drinkless/tdlib/TdApi$CallDiscardReason;

.field public duration:I

.field public isVideo:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38436
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38437
    return-void
.end method

.method public constructor <init>(ZLorg/drinkless/tdlib/TdApi$CallDiscardReason;I)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "callDiscardReason"    # Lorg/drinkless/tdlib/TdApi$CallDiscardReason;
    .param p3, "i9"    # I

    .line 38425
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38426
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$MessageCall;->isVideo:Z

    .line 38427
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageCall;->discardReason:Lorg/drinkless/tdlib/TdApi$CallDiscardReason;

    .line 38428
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$MessageCall;->duration:I

    .line 38429
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38433
    const v0, 0x201ede00

    return v0
.end method
