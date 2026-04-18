.class public Lorg/drinkless/tdlib/TdApi$SendPassportAuthorizationForm;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendPassportAuthorizationForm"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x26df2ebd


# instance fields
.field public authorizationFormId:I

.field public types:[Lorg/drinkless/tdlib/TdApi$PassportElementType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30888
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30889
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$PassportElementType;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "passportElementTypeArr"    # [Lorg/drinkless/tdlib/TdApi$PassportElementType;

    .line 30878
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30879
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$SendPassportAuthorizationForm;->authorizationFormId:I

    .line 30880
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SendPassportAuthorizationForm;->types:[Lorg/drinkless/tdlib/TdApi$PassportElementType;

    .line 30881
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30885
    const v0, 0x26df2ebd

    return v0
.end method
