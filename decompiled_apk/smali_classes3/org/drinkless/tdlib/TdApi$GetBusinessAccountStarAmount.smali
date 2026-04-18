.class public Lorg/drinkless/tdlib/TdApi$GetBusinessAccountStarAmount;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetBusinessAccountStarAmount"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StarAmount;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6c4f4e35


# instance fields
.field public businessConnectionId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12156
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12157
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 12147
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12148
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetBusinessAccountStarAmount;->businessConnectionId:Ljava/lang/String;

    .line 12149
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12153
    const v0, -0x6c4f4e35

    return v0
.end method
