.class public Lorg/drinkless/tdlib/TdApi$GetPassportAuthorizationFormAvailableElements;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetPassportAuthorizationFormAvailableElements"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PassportElementsWithErrors;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3fb314fc


# instance fields
.field public authorizationFormId:I

.field public password:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26504
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26505
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;

    .line 26494
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26495
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GetPassportAuthorizationFormAvailableElements;->authorizationFormId:I

    .line 26496
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetPassportAuthorizationFormAvailableElements;->password:Ljava/lang/String;

    .line 26497
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26501
    const v0, 0x3fb314fc

    return v0
.end method
