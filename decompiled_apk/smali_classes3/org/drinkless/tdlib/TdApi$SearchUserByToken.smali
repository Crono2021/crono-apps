.class public Lorg/drinkless/tdlib/TdApi$SearchUserByToken;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchUserByToken"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$User;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x27be0bca


# instance fields
.field public token:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19230
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19231
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 19221
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19222
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchUserByToken;->token:Ljava/lang/String;

    .line 19223
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19227
    const v0, -0x27be0bca

    return v0
.end method
