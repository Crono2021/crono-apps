.class public Lorg/drinkless/tdlib/TdApi$SetBotUpdatesStatus;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetBotUpdatesStatus"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x44d6c66f


# instance fields
.field public errorMessage:Ljava/lang/String;

.field public pendingUpdateCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31048
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31049
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;

    .line 31038
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31039
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$SetBotUpdatesStatus;->pendingUpdateCount:I

    .line 31040
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetBotUpdatesStatus;->errorMessage:Ljava/lang/String;

    .line 31041
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31045
    const v0, -0x44d6c66f

    return v0
.end method
