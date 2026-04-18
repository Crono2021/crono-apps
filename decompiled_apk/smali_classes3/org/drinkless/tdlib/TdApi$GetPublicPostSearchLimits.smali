.class public Lorg/drinkless/tdlib/TdApi$GetPublicPostSearchLimits;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetPublicPostSearchLimits"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PublicPostSearchLimits;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x66c575c5


# instance fields
.field public query:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13380
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13381
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 13371
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13372
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetPublicPostSearchLimits;->query:Ljava/lang/String;

    .line 13373
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13377
    const v0, -0x66c575c5

    return v0
.end method
