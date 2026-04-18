.class public Lorg/drinkless/tdlib/TdApi$SearchCallMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchCallMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FoundMessages;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x73c410e5


# instance fields
.field public limit:I

.field public offset:Ljava/lang/String;

.field public onlyMissed:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39822
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39823
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;IZ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I
    .param p3, "z8"    # Z

    .line 39811
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39812
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchCallMessages;->offset:Ljava/lang/String;

    .line 39813
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$SearchCallMessages;->limit:I

    .line 39814
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$SearchCallMessages;->onlyMissed:Z

    .line 39815
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39819
    const v0, -0x73c410e5

    return v0
.end method
