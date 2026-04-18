.class public Lorg/drinkless/tdlib/TdApi$SetBusinessAccountBio;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetBusinessAccountBio"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x653da239


# instance fields
.field public bio:Ljava/lang/String;

.field public businessConnectionId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31068
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31069
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 31058
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31059
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetBusinessAccountBio;->businessConnectionId:Ljava/lang/String;

    .line 31060
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetBusinessAccountBio;->bio:Ljava/lang/String;

    .line 31061
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31065
    const v0, -0x653da239

    return v0
.end method
