.class public Lorg/drinkless/tdlib/TdApi$ImportContacts;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ImportContacts"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ImportedContacts;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x277dcd37


# instance fields
.field public contacts:[Lorg/drinkless/tdlib/TdApi$ImportedContact;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14262
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 14263
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$ImportedContact;)V
    .locals 0
    .param p1, "importedContactArr"    # [Lorg/drinkless/tdlib/TdApi$ImportedContact;

    .line 14253
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 14254
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ImportContacts;->contacts:[Lorg/drinkless/tdlib/TdApi$ImportedContact;

    .line 14255
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14259
    const v0, -0x277dcd37

    return v0
.end method
