.class public Lorg/drinkless/tdlib/TdApi$TransferBusinessAccountStars;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TransferBusinessAccountStars"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2baa0420


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33628
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33629
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;J)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J

    .line 33618
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33619
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TransferBusinessAccountStars;->businessConnectionId:Ljava/lang/String;

    .line 33620
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$TransferBusinessAccountStars;->starCount:J

    .line 33621
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33625
    const v0, 0x2baa0420

    return v0
.end method
